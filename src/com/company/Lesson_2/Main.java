package com.company.Lesson_2;

public class Main {
    public static void main(String[] args) {
        String[][] good_array = {{"1", "2", "3", "4"}, {"5", "6", "7", "8"}};
        String[][] error_size = {{"1", "2", "3", "4", "6"}, {"5", "6", "7", "8"}};
        String[][] error_data = {{"1", "2", "df3", "4"}, {"5", "6", "7", "4fr"}};

        System.out.println(analise(good_array));
        System.out.println(analise(error_size));
        System.out.println(analise(error_data));

    }

    public static int analise(String[][] array) throws MyArrayDataException, MyArraySizeException{
        int sum = 0;

        if(array.length > 2 || array[0].length > 4 || array[1].length >4){
            throw new MyArraySizeException();
        }

        try {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length ; j++) {
                    sum += Integer.parseInt(array[i][j]);
                }
            }
        }catch (MyArrayDataException e){
            System.out.println(e.getMessage());
        }catch (IllegalArgumentException e){
            throw new MyArrayDataException(e.getMessage());
        }
        return sum;
    }
}
