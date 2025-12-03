package by.andrew.task1.repository.impl;

import by.andrew.task1.entity.CustomArray;
import by.andrew.task1.exception.CustomArrayException;
import by.andrew.task1.repository.CustomArrayRepository;
import by.andrew.task1.specification.impl.SumGreaterThanSpecification;
import by.andrew.task1.comparator.CustomArrayByIdComparator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CustomArrayRepositoryImplTest {
  private CustomArrayRepository repository;
  private CustomArray array1;
  private CustomArray array2;
  private CustomArray array3;

  @BeforeEach
  void setUp() throws CustomArrayException {
    repository = CustomArrayRepositoryImpl.getInstance();
    array1 = new CustomArray(new int[]{1, 2, 3});
    array2 = new CustomArray(new int[]{4, 5, 6});
    array3 = new CustomArray(new int[]{7, 8, 9});
  }

  @AfterEach
  void tearDown() {
      repository.findAll().forEach(repository::remove);
  }

  @Test
  void testGetInstanceReturnsSameInstance() {
    CustomArrayRepository instance1 = CustomArrayRepositoryImpl.getInstance();
    CustomArrayRepository instance2 = CustomArrayRepositoryImpl.getInstance();
    assertSame(instance1, instance2);
  }

  @Test
  void testAddAndFindAll() throws CustomArrayException {
    repository.add(array1);
    repository.add(array2);
    
    List<CustomArray> all = repository.findAll();
    assertEquals(2, all.size());
    assertTrue(all.contains(array1));
    assertTrue(all.contains(array2));
  }

  @Test
  void testAddNullDoesNotAdd() {
    int initialSize = repository.findAll().size();
    repository.add(null);
    assertEquals(initialSize, repository.findAll().size());
  }

  @Test
  void testAddDuplicateDoesNotAdd() {
    repository.add(array1);
    int sizeAfterFirstAdd = repository.findAll().size();
    repository.add(array1);
    assertEquals(sizeAfterFirstAdd, repository.findAll().size());
  }

  @Test
  void testFindById() {
    repository.add(array1);
    repository.add(array2);
    
    Optional<CustomArray> found = repository.findById(array1.getId());
    assertTrue(found.isPresent());
    assertEquals(array1, found.get());
  }

  @Test
  void testFindByIdNotFound() {
    Optional<CustomArray> found = repository.findById(999);
    assertFalse(found.isPresent());
  }

  @Test
  void testRemove() {
    repository.add(array1);
    repository.add(array2);
    
    repository.remove(array1);
    List<CustomArray> remaining = repository.findAll();
    assertEquals(1, remaining.size());
    assertFalse(remaining.contains(array1));
    assertTrue(remaining.contains(array2));
  }

  @Test
  void testRemoveNullDoesNothing() {
    repository.add(array1);
    int initialSize = repository.findAll().size();
    repository.remove(null);
    assertEquals(initialSize, repository.findAll().size());
  }

  @Test
  void testUpdate() throws CustomArrayException {
    repository.add(array1);
    CustomArray updatedArray = new CustomArray(new int[]{10, 20, 30});
    
    repository.update(updatedArray);
    
    Optional<CustomArray> found = repository.findById(array1.getId());
    assertTrue(found.isPresent());
  }

  @Test
  void testFindBySpecification() {
    repository.add(array1);
    repository.add(array2);
    repository.add(array3);
    
    SumGreaterThanSpecification spec = new SumGreaterThanSpecification(10L);
    List<CustomArray> result = repository.findBySpecification(spec);
    
    assertEquals(2, result.size());
    assertTrue(result.contains(array2));
    assertTrue(result.contains(array3));
    assertFalse(result.contains(array1));
  }

  @Test
  void testSort() {
    repository.add(array3);
    repository.add(array1);
    repository.add(array2);
    
    repository.sort(new CustomArrayByIdComparator());
    List<CustomArray> sorted = repository.findAll();
    
    for (int i = 0; i < sorted.size() - 1; i++) {
      assertTrue(sorted.get(i).getId() <= sorted.get(i + 1).getId());
    }
  }
}
