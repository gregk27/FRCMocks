package ca.gregk.frcmocks;

import static org.mockito.Mockito.mock;

/**
 * Generic base class used for mock wrappers.
 * 
 * @param <T> The type of the mock
 */
public abstract class MockBase<T> {
    
    /**
     * The mock object.
     */
    protected T mock;

    /**
     * Instantiate the mock wrapper.
     */
    public MockBase() {
        initMock();
    }

    protected final void initMock(){
        mock = mock(getType());
        mapWrapper();
    }

    /**
     * Function called by the constructor to map functions to the mock.
     */
    protected abstract void mapWrapper();

    /**
     * Get the mock object to be passed to the subsystem.
     * 
     * @return The mock object
     */
    public T getMock() {
        return mock;
    }

    /**
     * Get the mock type class.
     * <p> The returned value is used in creating the mock
     * 
     * @return The mock type's <code>.class</code>
     */
    public abstract Class<T> getType();

}