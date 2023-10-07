package io.bigpel66.utility;

public final class DynamicTypeParser {

    public static Object parse(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e1) {
            try {
                return Long.parseLong(input);
            } catch (NumberFormatException e2) {
                try {
                    return Double.parseDouble(input);
                } catch (NumberFormatException e3) {
                    return input;
                }
            }
        }
    }

    public static Integer toInt(final Object input) {
        try {
            return (Integer) input;
        } catch (ClassCastException e1) {
            try {
                return ((Long) input).intValue();
            } catch (ClassCastException e2) {
                try {
                    return ((Double) input).intValue();
                } catch (ClassCastException e3) {
                    return Integer.parseInt(String.valueOf(input));
                }
            }
        }
    }

    private DynamicTypeParser() {
    }

}