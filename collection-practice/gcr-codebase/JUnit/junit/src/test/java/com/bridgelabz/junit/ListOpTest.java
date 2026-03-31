package com.bridgelabz.junit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import jar.ListOp;

public class ListOpTest {
	List<Integer>list=new ArrayList<>();

	@Test
	public void addElementTest() {
		ListOp.addElement(list, 10);
		ListOp.addElement(list, 20);
		assertTrue(list.contains(10));
	}
	
	@Test
    public void removeElementTest() {
		ListOp.addElement(list, 10);
		ListOp.addElement(list, 20);
		ListOp.removeElement(list, 10);
        assertFalse(list.contains(10));
    }

    @Test
    public void getSizeTest() {
    	ListOp.addElement(list, 10);
        ListOp.addElement(list, 20);
        assertEquals(2, ListOp.getSize(list));
    }
}