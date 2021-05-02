package com.github.curriculeon;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MyObjectTest {
    @Test
    public void test() {
        // given
        Integer idOfItemToBeRemoved1 = 12345;
        Integer idOfItemToBeRemoved2 = 56789;
        Item itemExpectedToBeDeleted1 = new Item(idOfItemToBeRemoved1, "nameOfItem", "descriptionOfItem");
        Item itemExpectedToBeDeleted2 = new Item(idOfItemToBeRemoved2, "nameOfItem", "descriptionOfItem");
        Item itemExpectedToBeRetained1 = new Item(34567, "nameOfItem", "descriptionOfItem");
        Item itemExpectedToBeRetained2 = new Item(98756, "nameOfItem", "descriptionOfItem");


        List<Integer> idsOfItemsToRemove = Arrays.asList(
                idOfItemToBeRemoved1,
                idOfItemToBeRemoved2);

        List<Item> listOfItems = Arrays.asList(
                itemExpectedToBeDeleted1,
                itemExpectedToBeDeleted2,
                itemExpectedToBeRetained1,
                itemExpectedToBeRetained2);

        List<Item> expectedList = Arrays.asList(
                itemExpectedToBeRetained1,
                itemExpectedToBeRetained2);

        // when
        List<Item> actualList = listOfItems
                .stream()
                .filter(item -> !idsOfItemsToRemove.contains(item.getId()))
                .collect(Collectors.toList());

        // then
        Assert.assertEquals(expectedList, actualList);
    }
}