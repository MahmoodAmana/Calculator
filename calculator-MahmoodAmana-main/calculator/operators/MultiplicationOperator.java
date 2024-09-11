package calculator.operators;

import calculator.evaluator.Operand;

public class MultiplicationOperator extends Operator {
    @Override
    public int priority() {
        return 2; // Higher priority than addition/subtraction
    }

    @Override
    public Operand execute(Operand operandOne, Operand operandTwo) {
        return new Operand(operandOne.getValue() * operandTwo.getValue());
    }
}