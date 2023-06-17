package com.softgraf.agenda.dao.abstrato;

import java.util.List;

public interface Pageable<T> {
	
	int getPageNumber();
	int getPageSize();
	void setPageSize(int Size);
	void first();
	List<T> next();
}
