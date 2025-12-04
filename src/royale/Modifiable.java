package royale;

public interface Modifiable {
	public boolean checkModification(Tool tool);
	public void modify(Tool tool);
}