package workshop01;

public interface CircularBuffer {

	public void create();
	public void create(int size);
	public void write(String input);
	public String read();
	public int getSize();
	public boolean isEmpty();
	public boolean isFull();

}
