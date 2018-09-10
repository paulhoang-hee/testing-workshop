# Testees testing repo

Tiny repo for a testing workshop.

Write tests that are:
- black box
- classic state based results testing
- white box
- mockist behaviour based testing

https://stackoverflow.com/questions/3459287/whats-the-difference-between-a-mock-stub

#### BB Testing

```java
class ATest {

  	@Test
	public void containsShouldReturnTrueWhenStringContainsCharSequence() {
    	boolean expected = true;
    
  		String value = "A SILLY STRING CONTAIN RANDOM CONTENT";
  		boolean result = value.contains("RANDOM");
  		
  		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void sortShouldSortCollectionsInNaturalOrder() {
  	  List<Integer> numbers = new ArrayList<>();
  	  numbers.add(3);
  	  numbers.add(4);
  	  numbers.add(1);
  	  numbers.add(5);
  	  numbers.add(2);
  	  Collections.sort(numbers);
  	  
  	  for(int i = 0; i < 5; i++) {
  	    Assert.assertEquals(i+1, numbers.get(0));
  	  }
	}
}
```

#### White Box Testing

```java

class ComplexClass {
    private ADependency dep;
    
    ComplexClass(ADependency dep) {
      this.dep = dep;
    }
    
    Number makeExternalCall(){
      
      Number num = this.dep.getANumber();
      // do some logic;
      // ...
      num = num * 2;
      
      return num;
    }
}
  
class AClassicTest {
  
  private ComplexClass testObj;
  
  private ADependencyStub depStub;
  
  class ADependencyStub implements ADependency {
    
    boolean called = false;
    
    boolean getNumberBeenCalled(){
      return called;
    }
    Long getANumber(){
      called = true;
      return 1L;
    }
  }
  
  @Before
  public void setup() {
    depStub = new ADependencyStub();
    testObj = new ComplexClass(depStub);
  }
  
  @Test
  public void callExtShouldMakeExternalCallAndReturnANumeral() {
    
    //trigger
    Number result = testObj.makeExternalCall();
    
    Assert.assertEquals(2L, result);
    
    //verify
    Assert.isTrue(depStub.getNumberBeenCalled());
  }
}

class AMockistTest {
  
  @InjectMock
  private ComplexClass testObj;
  @Mock
  private ADependency depMock;
  
  @Test
  public void callExtShouldMakeExternalCallAndReturnANumeral() {
    when(depMock.getANumber()).thenReturn(1L);
    
    Assert.assertEquals(2L, result);
    
    verify(depMock, once()).getNumber();
  }
}

```