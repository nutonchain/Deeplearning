package org.nd4j.linalg.dataset;

import org.nd4j.linalg.api.ndarray.INDArray;

/**
 * Interface for certain statistics about a population of data.
 * Can be constructed incrementally by using the Builder, which is useful for obtaining these statistics from an
 * iterator.
 *
 * @author Ede Meijer
 */
public interface NormalizerStats {
    interface Builder<S extends NormalizerStats> {
        Builder<S> addFeatures(org.nd4j.linalg.dataset.api.DataSet dataSet);

        /**
         * Add the labels of a DataSet to the statistics
         */
        Builder<S> addLabels(org.nd4j.linalg.dataset.api.DataSet dataSet);

        /**
         * Add rows of data to the statistics
         *
         * @param data the matrix containing multiple rows of data to include
         * @param mask (optionally) the mask of the data, useful for e.g. time series
         */
        Builder<S> add(INDArray data, INDArray mask);

        S build();
    }
}
