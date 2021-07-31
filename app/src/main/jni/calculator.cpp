#include <stdlib.h>
#include <iostream>
#include <string.h>
#include <vector>
#include <list>
#include <stack>
#include <queue>
#include <sstream>
 
using namespace std;
 
typedef struct{
    double operand;
    char opt;
}PostNode;
 
class FourArithmeticOP {
private:
    const char NO_OPERATOR = 0x00;

    stack<char, list<char> > OpStack;
    queue<PostNode, list<PostNode> > PostStr;
    stack<double, list<double> > OperandStack;


public:
    FourArithmeticOP() {
        OpStack.push('#');
    }

    ~FourArithmeticOP() {

    }

//    int IsNumOrDot(char chra);
//    int IsOperator(char chra);
//    int NormalPriority(char opt);
//    int StackPriority(char opt);
//
//    int InorderToPost(char *cExp);
//    void ShowPostStr();
//    double Calculate();
//};

    int IsNumOrDot(char chra) {
        if ((chra >= '0' && chra <= '9') || chra == '.')
            return 1;
        return 0;
    }

    int IsOperator(char chra) {
        if (chra == '+' || chra == '-' ||
            chra == '*' || chra == '/' ||
            chra == '(' || chra == ')')
            return 1;
        return 0;
    }

    int NormalPriority(char opt) {
        int priority;
        switch (opt) {
            case '+' :
                priority = 2;
                break;
            case '-' :
                priority = 2;
                break;
            case '*' :
                priority = 4;
                break;
            case '/' :
                priority = 4;
                break;
            case '(' :
                priority = 10;
                break;
            case ')' :
                priority = 1;
                break;
            default:
                priority = 0;
                break;
        }
        return priority;
    }

//相同运算符，在栈中优先级更高
    int StackPriority(char opt) {
        int priority;
        switch (opt) {
            case '+' :
                priority = 3;
                break;
            case '-' :
                priority = 3;
                break;
            case '*' :
                priority = 5;
                break;
            case '/' :
                priority = 5;
                break;
            case '(' :
                priority = 1;
                break;
            case ')' :
                priority = 10;
                break;
            default:
                priority = 0;
                break;
        }
        return priority;
    }

    string InorderToPost(char *cExp) {
        string NumStr;
        //    double num;
        PostNode node;
        string excepinfo;
        int i = 0;
        while (i < strlen(cExp)) {
            NumStr.clear();
            while (IsNumOrDot(cExp[i])) {
                NumStr += cExp[i];
                i++;
            }//get int or float
            if (!NumStr.empty()) {
                if ('.' == NumStr.at(NumStr.length() - 1) ||
                    '.' == NumStr.at(0)) {
//                    cout << "valid float : " << NumStr << endl;
//                    return 0;
                    excepinfo="ERROR(invalid float) : "+NumStr;
                    return excepinfo;
                }
                node.operand = atof(NumStr.c_str());
                node.opt = NO_OPERATOR;
                PostStr.push(node);
            } else if (IsOperator(cExp[i])) {
                if (')' == cExp[i]) {
                    //遇到 ) 则 一直弹出直到 (
                    while ('(' != OpStack.top()) {
                        if ('#' == OpStack.top()) {
//                            cout << "parenthesis error" << endl;
//                            return 0;
                            excepinfo="ERROR(parenthesis error)";
                            return excepinfo;
                        }
                        //pop out pair parenthesis
                        node.opt = OpStack.top();
                        PostStr.push(node);
                        OpStack.pop();
                    }
                    OpStack.pop(); //pop out '('
                    i++;
                    continue;
                }
                while (NormalPriority(cExp[i]) <= StackPriority(OpStack.top())) {
                    node.opt = OpStack.top();
                    PostStr.push(node);
                    OpStack.pop();
                }
                OpStack.push(cExp[i]);
                i++;
            } else {
//                cout << "valid operator : " << cExp[i] << endl;
//                return 0;
                excepinfo= "ERROR(invalid operator) : " + cExp[i];
                return excepinfo;
            }
        }
        while ('#' != OpStack.top()) {
            node.opt = OpStack.top();
            PostStr.push(node);
            OpStack.pop();
        }
//        return 1;
        return "pass";
    }

    string Calculate() {
        PostNode node;
        double operand_1;
        double operand_2;
        char Operator;
        while (!PostStr.empty()) {
            Operator = PostStr.front().opt;
            //operand
            if (NO_OPERATOR == Operator) {
                operand_1 = PostStr.front().operand;
                OperandStack.push(operand_1);
                //            Operator = PostStr.front().opt;
            } else {
                //handle operator
                operand_2 = OperandStack.top();
                OperandStack.pop();
                operand_1 = OperandStack.top();
                OperandStack.pop();
                switch (Operator) {
                    case '+' :
                        OperandStack.push(operand_1 + operand_2);
                        break;
                    case '-' :
                        OperandStack.push(operand_1 - operand_2);
                        break;
                    case '*' :
                        OperandStack.push(operand_1 * operand_2);
                        break;
                    case '/' :
                        if (0 == operand_2) {
//                            cout << "operand_2 = 0 while /" << endl;
                            return "ERROR:除数不能为0";
                        } else {
                            OperandStack.push(operand_1 / operand_2);
                        }
                }
            }
            PostStr.pop();
        }
        //return res;
        double res = OperandStack.top();
        OperandStack.pop();

//        char buffer [100];
//        char *output = buffer;
//        sprintf(output, "%f",res);

        stringstream stream;
        string output;
        stream << res;
        stream >> output;
        return output;
    }
};