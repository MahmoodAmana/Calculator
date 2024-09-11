package calculator.operators;

import calculator.evaluator.Operand;

public class DivisionOperator extends Operator {
    @Override
    public int priority() {
        return 2; // Same priority as multiplication
    }

    @Override
    public Operand execute(Operand operandOne, Operand operandTwo) {
        return new Operand(operandOne.getValue() / operandTwo.getValue());
    }
}