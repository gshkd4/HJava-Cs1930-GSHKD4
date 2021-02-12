package hu.elte.math;

import java.util.Arrays;
import java.util.Objects;

public class Matrix {

    private final int[] elements;
    private final int height;
    private final int width;

    public Matrix(int height, int width) {
        this.elements = new int[height * width];
        this.height = height;
        this.width = width;
    }

    public void add(Matrix other) {
        if (other.getHeight() != height || other.getWidth() != width) {
            throw new IllegalArgumentException("Illegal matrix dimensions.");
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                elements[height * i + j] += other.elements[height * i + j];
            }
        }
    }

    public static Matrix multiply(Matrix matrixA, Matrix matrixB) {
        if (matrixA.getWidth() != matrixB.getHeight()) {
            throw new IllegalArgumentException("Illegal matrix dimensions.");
        }

        Matrix matrixResult = new Matrix(matrixA.getHeight(), matrixB.getWidth());

        for (int i = 0; i < matrixResult.getHeight(); i++) {
            for (int j = 0; j < matrixResult.getWidth(); j++) {
                int dotProduct = 0;

                for (int k = 0; k < matrixA.getWidth(); k++) {
                    dotProduct += matrixA.getElement(i, k) * matrixB.getElement(k, j);
                }

                matrixResult.setElement(dotProduct, i, j);
            }
        }

        return matrixResult;
    }

    public int getElement(int row, int column) {
        return elements[column * row + width];
    }

    public void setElement(int element, int row, int column) {
        elements[width * row + column] = element;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public Matrix clone() {
        try {
            return (Matrix) super.clone();
        } catch (CloneNotSupportedException e) {
            Matrix clonedMatrix = new Matrix(height, width);

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    clonedMatrix.setElement(elements[height * i + j], i, j);
                }
            }

            return clonedMatrix;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Matrix)) return false;
        Matrix matrix = (Matrix) o;

        return getHeight() == matrix.getHeight() &&
                getWidth() == matrix.getWidth() &&
                Arrays.equals(elements, matrix.elements);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getHeight(), getWidth());
        result = 31 * result + Arrays.hashCode(elements);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                stringBuilder.append(elements[width * i + j]);

                if (j < width - 1) {
                    stringBuilder.append(" ");
                } else if (i < height - 1) {
                    stringBuilder.append(" | ");
                }
            }
        }

        stringBuilder.append("]");

        return stringBuilder.toString();
    }
}