package repository;

import java.util.List;

public interface repository <T>{
    List<T> list ();
    T byId(Integer id_factura);
    void save (T t);
    void delete (Long id);
}
