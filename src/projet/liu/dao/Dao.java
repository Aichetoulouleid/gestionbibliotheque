package projet.liu.dao;

import java.util.List;

public interface Dao<T> {
	public T get(long id);

	public List<T> getAll();

	public void save(T t);

	public void update(T t, String[] params);

	public void delete(T t);

}
