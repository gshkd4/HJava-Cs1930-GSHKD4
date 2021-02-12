package hu.elte.math;

import org.junit.Test;
import org.junit.Assert;

public class MatrixTest {

    @Test
    public void shouldAddTwoMatrices() {
        final Matrix matrixA = createMatrix(1, 5, 5);
        final Matrix matrixB = createMatrix(1, 5, 5);
        final Matrix correctSum = createMatrix(2, 5, 5);

        matrixA.add(matrixB);
        Assert.assertEquals(matrixA, correctSum);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnIllegalArgumentExceptionWhenAddingMatricesWithDifferingDimensions() {
        final Matrix matrixA = createMatrix(1, 5, 5);
        final Matrix matrixB = createMatrix(1, 5, 6);

        matrixA.add(matrixB);
    }

    @Test
    public void shouldMultiplyTwoMatrices() {
        final Matrix matrixA = createMatrix(2, 3, 5);
        final Matrix matrixB = createMatrix(3, 5, 2);
        final Matrix correctMultiple = createMatrix(30, 3, 2);

        Assert.assertEquals(Matrix.multiply(matrixA, matrixB), correctMultiple);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnIllegalArgumentExceptionWhenMultiplyingMatricesWithWrongDimensions() {
        final Matrix matrixA = createMatrix(1, 1, 5);
        final Matrix matrixB = createMatrix(1, 6, 1);

        Matrix.multiply(matrixA, matrixB);
    }

    @Test
    public void shouldReturnAProperlyFormattedMatrixString() {
        final Matrix matrixA = createMatrix(2, 3, 5);

        Assert.assertEquals(matrixA.toString(), "[2 2 2 2 2 | 2 2 2 2 2 | 2 2 2 2 2]");
    }

    public Matrix createMatrix(int defaultElement, int height, int width) {
        final Matrix matrix = new Matrix(height, width);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                matrix.setElement(defaultElement, i, j);
            }
        }

        return matrix;
    }
}
