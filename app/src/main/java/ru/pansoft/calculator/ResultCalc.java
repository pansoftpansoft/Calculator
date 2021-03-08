package ru.pansoft.calculator;

import android.util.Log;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class ResultCalc {
    final int countZero = 2;
    boolean clearExpression = false;
    String expression = "";
    String[] dataOperation = {"+", "-", "*", "/", "="};
    String[] dataNumber = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "."};
    ArrayList<Integer> allNumber = new ArrayList<>();
    ArrayList<String> allOperation = new ArrayList<>();

    public void setTextMonitor(String symbol) {

        if (clearExpression) {
            clearExpression = false;
            expression = "";
        }

        if (Arrays.asList(dataOperation).indexOf(symbol) >= 0) {
            //Если ввели операцию проверяем последний символ на цифру
            Log.e("2 symbol", symbol);
            if (Arrays.asList(dataNumber).indexOf(expression.substring(expression.length() - 1)) >= 0) {
                expression += symbol;
                if (symbol.equals("=")) {
                    calc();
                }
            } else {
                return;
            }
        } else {
            int point = expression.lastIndexOf('.');
            Log.e("point", Integer.toString(point));
            if (expression.length() - point > 2 && point > -1) {
                //error перебор чисел после запятой
                try {
                    if (Arrays.asList(dataOperation).indexOf(expression.substring(point + 2, point + 3)) >= 0) {
                        Log.e("point", "symbol 3");
                        expression += symbol;
                    } else {
                        Log.e("point", "symbol 11 11");
                        return;
                    }
                } catch (StringIndexOutOfBoundsException e) {
                    if (Arrays.asList(dataOperation).indexOf(expression.substring(point + 1, point + 2)) >= 0) {
                        Log.e("point", "symbol 4");
                        expression += symbol;
                    } else {
                        Log.e("point", "symbol 22 22");
                        return;
                    }
                }
            } else {
                expression += symbol;
            }
            calc();
        }
        Log.e("expression = ", expression);
        return;
    }

    private void calc() {
        allNumber.clear();
        allOperation.clear();
        String resultString = "";
        String s1 = "";
        String operation = "";
        Integer currentNumber = 0;
        String[] arrayC = expression.split("");
        for (String c : arrayC) {
            if (Arrays.asList(dataNumber).indexOf(c) >= 0) {
                s1 += c;
            } else {
                int i = s1.indexOf('.');
                if (i > -1) {
                    if (i == 0) {
                        if (s1.length() == 2) {
                            s1 = s1 + "0";
                        }
                        resultString = s1.substring(1);
                    }
                    if (i == s1.length() - 2) {
                        resultString = s1.substring(0, i) + s1.substring(i + 1) + "0";
                    }
                    if (i == s1.length() - 3) {
                        resultString = s1.substring(0, i) + s1.substring(i + 1);
                    }
                    currentNumber = Integer.parseInt(resultString);
                    //currentNumber = currentNumber * 100;
                } else {
                    if (s1.length() > 0) {
                        currentNumber = Integer.parseInt(s1);
                        currentNumber = currentNumber * 100;
                    }
                }

                Log.e("1", c);


                if (c.equals("")) {
                    if (s1.length() > 0) {

                    }
                } else {
                    if (c.equals("+")) {
                        allNumber.add(currentNumber);
                        allOperation.add("+");
                    }
                    if (c.equals("-")) {
                        allNumber.add(currentNumber);
                        allOperation.add("-");
                    }
                    if (c.equals("*")) {
                        allNumber.add(currentNumber);
                        allOperation.add("*");
                    }
                    if (c.equals("/")) {
                        allNumber.add(currentNumber);
                        allOperation.add("/");
                    }
                    if (c.equals("√")) {
                        if (allNumber.size() > 0) {
                            allNumber.add(currentNumber);
                            allOperation.add("√");
                        }
                    }
                    if (c.equals("=")) {
                        clearExpression = true;
                        allNumber.add(currentNumber);
                        getResult();
                    }
                    s1 = "";
                    currentNumber = 0;
                }
            }
        }
    }

    private void getResult() {
        //Integer[] allNumber={};
        //String[] allOperation={};
        int result = 0;
        result = allNumber.get(0);
        Log.e("allNumber.size()", Integer.toString(allNumber.size()));
        Log.e("allNumber.size()", allNumber.toString());
        Log.e("allOperation.size()", Integer.toString(allOperation.size()));
        Log.e("allOperation.size()", allOperation.toString());
        for (int i = 0; i < allOperation.size(); i++) {
            if (allOperation.get(i).equals("+")) {
                result = result + allNumber.get(i + 1);
            }
            if (allOperation.get(i).equals("-")) {
                Log.e("result - ", Integer.toString(result));
                Log.e("allNumber.get(i + 1) - ", Integer.toString(allNumber.get(i + 1)));
                result = result - allNumber.get(i + 1);
            }
            if (allOperation.get(i).equals("*")) {
                result = result * allNumber.get(i + 1);
                result = result / 100;
            }
            if (allOperation.get(i).equals("/")) {
                double r = 0;
                r = ((double) result / (double) allNumber.get(i + 1));
                result = (int) (r * 100);
            }
            Log.e("result", Integer.toString(result));
        }
        if (Math.abs(result % 100) > 0) {
            if (Math.abs(result % 100) < 10) {
                expression = Integer.toString(result / 100) + ".0" + Math.abs(result % 100);
                Log.e("1 expression ==", Integer.toString(result));
            } else {
                expression = Integer.toString(result / 100) + "." + Math.abs(result % 100);
                Log.e("2 expression ==", Integer.toString(result));
            }
        } else {
            expression = Integer.toString(result / 100);
            Log.e("3 expression ==", Integer.toString(result));
        }

        allNumber.clear();
        allOperation.clear();
    }
}
