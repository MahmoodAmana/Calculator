package calculator.operators;

import calculator.evaluator.Operand;

public class SubtractionOperator extends Operator {
    @Override
    public int priority() {
        return 1; // Same priority as addition
    }

    @Override
    public Operand execute(Operand operandOne, Operand operandTwo) {
        return new Operand(operandOne.getValue() - operandTwo.getValue());
    }
}