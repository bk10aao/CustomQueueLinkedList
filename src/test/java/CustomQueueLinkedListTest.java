import org.customqueuelinkedlist.CustomQueueLinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CustomQueueLinkedListTest {

    @Test
    public void givenDefaultQueue_returns_NullPointerException_whenAdding_null() {
        assertThrows(NullPointerException.class, () -> new CustomQueueLinkedList<>().add(null));
    }

    @Test
    public void givenDefaultQueue_returns_true_whenAdding_valueOf_10() {
        CustomQueueLinkedList<Integer> customQueue = new CustomQueueLinkedList<>();
        assertTrue(customQueue.add(10));
        assertEquals(1, customQueue.size());
    }

    @Test
    public void givenDefaultQueue_returns_true_whenAdding_10() {
        CustomQueueLinkedList<Integer> customQueue = new CustomQueueLinkedList<>();
        assertTrue(customQueue.add(10));
    }

    @Test
    public void givenDefaultQueue_returns_NullPointerException_whenOfferingNullItem() {
        assertThrows(NullPointerException.class, () -> new CustomQueueLinkedList<>().offer(null));
    }

    @Test
    public void givenDefaultQueue_returns_true_whenOffering_whenQueueHasSpace() {
        CustomQueueLinkedList<Integer> customQueue = new CustomQueueLinkedList<>();
        assertTrue(customQueue.offer(10));
    }

    @Test
    public void givenDefaultQueue_returns_true_whenOffering_whenQueueIsNotFull() {
        CustomQueueLinkedList<Integer> customQueue = new CustomQueueLinkedList<>();
        assertTrue(customQueue.offer(10));
    }

    @Test
    public void givenQueueOfSize_10_returns_true_whenOffering_whenQueueIsNotFull() {
        CustomQueueLinkedList<Integer> customQueue = new CustomQueueLinkedList<>();
        assertTrue(customQueue.offer(10));
    }

    @Test
    public void givenDefaultQueue_is_empty_onRemove_returns_NoSuchElementException() {
        assertThrows(NoSuchElementException.class, new CustomQueueLinkedList<>()::remove);
    }

    @Test
    public void givenDefaultQueue_which_contains_oneElementOf_10_returns_1_withSizeOf_0_on_remove() {
        CustomQueueLinkedList<Integer> customQueue = new CustomQueueLinkedList<>();
        assertTrue(customQueue.add(10));
        assertEquals(1, customQueue.size());
        assertEquals(10, customQueue.remove());
        assertEquals(0, customQueue.size());
    }

    @Test
    public void givenQueueOfSize_10_which_contains_oneElementOf_10_returns_10_withSizeOf_0_on_remove() {
        CustomQueueLinkedList<Integer> customQueue = new CustomQueueLinkedList<>();
        assertTrue(customQueue.add(10));
        assertEquals(1, customQueue.size());
        assertEquals(10, customQueue.remove());
        assertEquals(0, customQueue.size());
    }

    @Test
    public void givenQueueOfSize_8_which_contains_threeElementsOf_10_returns_10_withQueueSize_4_on_removing_6_times() {
        CustomQueueLinkedList<Integer> customQueue = new CustomQueueLinkedList<>();
        IntStream.range(0, 8).mapToObj(i -> customQueue.add(10)).forEach(Assertions::assertTrue);
        assertEquals(8, customQueue.size());
        IntStream.range(0, 5).mapToObj(i -> customQueue.remove()).forEach(Assertions::assertNotNull);
        assertEquals(10, customQueue.remove());
        assertEquals(2, customQueue.size());
    }

    @Test
    public void givenDefaultQueue_is_empty_returns_null_on_poll() {
        assertNull(new CustomQueueLinkedList<>().poll());
    }

    @Test
    public void givenDefaultQueue_which_contains_oneElementOf_10_returns_1_withSizeOf_0_on_poll() {
        CustomQueueLinkedList<Integer> customQueue = new CustomQueueLinkedList<>();
        customQueue.add(10);
        assertEquals(10, customQueue.remove());
        assertEquals(0, customQueue.size());
    }

    @Test
    public void givenQueueOfSize_10_which_contains_oneElementOf_10_returns_10_withSizeOf_0_on_poll() {
        CustomQueueLinkedList<Integer> customQueue = new CustomQueueLinkedList<>();
        assertTrue(customQueue.add(10));
        assertEquals(10, customQueue.remove());
        assertEquals(0, customQueue.size());
    }

    @Test
    public void givenQueueOfSize_8_which_contains_threeElementsOf_10_returns_10_withQueueSize_4_on_poll_6_times() {
        CustomQueueLinkedList<Integer> customQueue = new CustomQueueLinkedList<>();
        IntStream.range(0, 8).mapToObj(i -> 10).forEach(customQueue::add);
        IntStream.range(0, 5).forEach(i -> customQueue.remove());
        assertEquals(10, customQueue.remove());
        assertEquals(2, customQueue.size());
    }

    @Test
    public void givenQueueOfSize_5_whensAddingSixValues_throws_IllegalStateException() {
        CustomQueueLinkedList<Integer> customQueueLinkedList = new CustomQueueLinkedList<>(5);
        IntStream.range(0, 5).forEach(customQueueLinkedList::add);
        assertThrows(IllegalStateException.class, () -> customQueueLinkedList.add(6));
    }

    @Test
    public void givenDefaultQueue_onAdding_12_values_throws_IllegalStateException() {
        CustomQueueLinkedList<Integer> customQueueLinkedList = new CustomQueueLinkedList<>();
        IntStream.range(0, 11).forEach(customQueueLinkedList::add);
        assertThrows(IllegalStateException.class, () -> customQueueLinkedList.add(11));
    }

    @Test
    public void givenQueueOfSize_5_whensOfferingSixValues_returnsFalseOnLastOffer() {
        CustomQueueLinkedList<Integer> customQueueLinkedList = new CustomQueueLinkedList<>(5);
        IntStream.range(0, 5).mapToObj(customQueueLinkedList::offer).forEach(Assertions::assertTrue);
        assertFalse(customQueueLinkedList.offer(5));
    }

    @Test
    public void givenQueueWithNoValues_onElement_throws_NoSuchElementException() {
        assertThrows(NoSuchElementException.class, () -> new CustomQueueLinkedList<>().element());
    }

    @Test
    public void givenQueueWithValues_0_to_9_returns_0_onElement_andDoesNotRemoveOrDecreaseSize() {
        CustomQueueLinkedList<Integer> customQueueLinkedList = new CustomQueueLinkedList<>();
        IntStream.range(0, 10).mapToObj(customQueueLinkedList::offer).forEach(Assertions::assertTrue);
        assertEquals(10, customQueueLinkedList.size());
        assertEquals(0, customQueueLinkedList.element());
        assertEquals(10, customQueueLinkedList.size());
        assertNotEquals(1, customQueueLinkedList.element());
    }

    @Test
    public void givenEmptyQueue_onPeek_throws_NoSuchElementException() {
        assertThrows(NoSuchElementException.class, () -> new CustomQueueLinkedList<>().peek());
    }
}