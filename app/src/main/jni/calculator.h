//
// Created by yuzonghang on 2021-08-05.
//

#ifndef CAL2_CALCULATOR_H
#define CAL2_CALCULATOR_H

#include <iostream>
#include <vector>
#include <list>
#include <stack>
#include <queue>
#include <sstream>
#include <cstdlib>

typedef struct{
    double operand;
    char opt;
}PostNode;

class FourArithmeticOP {
private:
    const char NO_OPERATOR = 0x00;
    bool neg_flag = false;
    bool bra_flag = false;
    std::stack<char, std::list<char> > OpStack;
    std::queue<PostNode, std::list<PostNode> > PostStr;
    std::stack<double, std::list<double> > OperandStack;

public:
    FourArithmeticOP() {
        // 加入一个优先级最低的特殊字符，使opStack不为空
        OpStack.push('#');
    }
    ~FourArithmeticOP() = default;
    static int IsNumOrDot(char chra);
    static int IsOperator(char chra);
    static int NormalPriority(char opt);
    static int StackPriority(char opt);
    std::string InorderToPost(char *cExp);
    std::string Calculate();
};
#endif
