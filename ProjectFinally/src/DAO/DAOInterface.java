package DAO;

public interface DAOInterface<T>{
        public int insert(T t);

        public int delete(T t);

        public int update(T t);

        public int insertRegister(T t);

        public int search(T t);
}
