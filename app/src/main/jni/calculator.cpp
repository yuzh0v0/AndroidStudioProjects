#include "calculator.h"
// 判断是否为操作数
int FourArithmeticOP::IsNumOrDot(char chra) {
    if ((chra >= '0' && chra <= '9') || chra == '.') return 1;
    return 0;
}

// 判断是否为运算符
int FourArithmeticOP::IsOperator(char chra) {
    if (chra == '+' || chra == '-' || chra == '*' || chra == '/' || chra == '(' ||
        chra == ')')
        return 1;
    return 0;
}

// 获得中序表达式中的优先级,+-的优先级一致，*/的优先级一致
int FourArithmeticOP::NormalPriority(char opt) {
    int priority;
    switch (opt) {
        case '+' :
        case '-' :
            priority = 2;
            break;
        case '*' :
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

// 对四则运算符，栈内优先级提升，'('的栈内优先级应该比所有的操作符都小，')'的栈内优先级应该最大
int FourArithmeticOP::StackPriority(char opt) {
    int priority;
    switch (opt) {
        case '+' :
        case '-' :
            priority = 3;
            break;
        case '*' :
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

// 中序表达式转为后序表达式
std::string FourArithmeticOP::InorderToPost(char *cExp) {
    std::string NumStr;
    PostNode node;
    std::string excepinfo;
    int i = 0;
    while (i < strlen(cExp)) {
        NumStr.clear();
        while (IsNumOrDot(cExp[i])) {
            // 判断是否为负数
            if (neg_flag && bra_flag) {
                NumStr += '-';
                neg_flag = false;
                NumStr += cExp[i];
            } else {
                NumStr += cExp[i];
            }
            bra_flag = false;
            i++;
        }
        if (!NumStr.empty()) {
            if ('.' == NumStr.at(NumStr.length() - 1) ||
                '.' == NumStr.at(0)) {
                excepinfo = "ERROR(invalid float) : " + NumStr;
                return excepinfo;
            }
            node.operand = strtod(NumStr.c_str(), nullptr);
            node.opt = NO_OPERATOR;
            PostStr.push(node);
        } else if (IsOperator(cExp[i])) {
            if ('(' == cExp[i]) bra_flag = true;
            if ('-' == cExp[i] && '(' == OpStack.top() && bra_flag) {
                neg_flag = true;
                i++;
                continue;
            }
            if (')' == cExp[i]) {
                // 遇到 ) 则 一直弹出直到 (
                while ('(' != OpStack.top()) {
                    if ('#' == OpStack.top()) {
                        excepinfo = "ERROR(parenthesis error)";
                        return excepinfo;
                    }
                    node.opt = OpStack.top();
                    PostStr.push(node);
                    OpStack.pop();
                }
                OpStack.pop(); // 弹出'('
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
            excepinfo = "ERROR(invalid operator) : ";
            excepinfo += cExp[i];
            return excepinfo;
        }
    }
    while ('#' != OpStack.top()) {
        node.opt = OpStack.top();
        PostStr.push(node);
        OpStack.pop();
    }
    return "pass";
}

std::string FourArithmeticOP::Calculate() {
    double operand_1;
    double operand_2;
    char Operator;
    while (!PostStr.empty()) {
        Operator = PostStr.front().opt;
        if (NO_OPERATOR == Operator) {
            operand_1 = PostStr.front().operand;
            OperandStack.push(operand_1);
        } else {
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
                        return "ERROR:除数不能为0";
                    } else OperandStack.push(operand_1 / operand_2);
                    break;
                default:
                    break;
            }
        }
        PostStr.pop();
    }
    //return res;
    double res = OperandStack.top();
    OperandStack.pop();

    //用sprintf把double转为string
    char buffer[111];
    char *output = buffer;
    sprintf(output, "%f", res);

    //用ostringstream把double转为string
//        stringstream stream;
//        string output;
//        stream << res;
//        stream >> output;
    return output;
}