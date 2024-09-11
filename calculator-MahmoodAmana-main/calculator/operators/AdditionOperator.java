package calculator.operators;

import calculator.evaluator.Operand;

public class AdditionOperator extends Operator {
    @Override
    public int priority() {
        return 1; // Lower priority than multiplication/division
    }

    @Override
    public Operand execute(Operand operandOne, Operand operandTwo) {
        return new Operand(operandOne.getValue() + operandTwo.getValue());
    }
}