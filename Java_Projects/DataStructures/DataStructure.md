这是一份在**保持原文内容和措辞完全不变**的前提下，对排版、Markdown 语法、代码高亮和数学公式进行优化的版本。

主要调整包括：
1.  **代码块增强**：添加了 `java` 语言标识，启用了语法高亮。
2.  **数学公式美化**：规范了 LaTeX 公式的换行和间距。
3.  **表格修复**：修复了原文本中表格对齐缺失的问题（Markdown 表格不支持自动合并单元格，已通过空白占位符修复对齐）。
4.  **引用与强调**：将 "Tip"、"Note" 和核心定义使用了引用块（Blockquote）或加粗处理，提升可读性。

---

## Data Structure

Data Structures is a function:

$$
F = G_a\circ G_b
$$

Where $G_a$ is an assignment function and $G_b$ is a function to build the house for the elements in some set.

$$
G_b:\emptyset \rightarrow \text{the set}\ \mathbb{B}
$$

$$
G_a:\text{the set}\ \mathbb{A} \lor\text{the set}\ \mathbb{B} \rightarrow \mathbb{A_{ordered}}
$$

Where each element in $\mathbb{A}$ has dimension(s) $n$, each element in $\mathbb{B}$ has dimension 1, so each element in $\mathbb{A_{ordered}}$ has dimension(s) $n+1$.

An appropriate data structure will provide appropriate management methods to manage the certain data, such as the method to read an element from the given set by checking the address, which is distributed to the certain element by $G_a$. With different data structures, the checking methods will be special from each other.

To talk about the $G_b$ in the Data Structure, we will first to talk about the algorithms that uses the management methods provided by the Data Structures as the basic operations.

---

## Algorithm

The algorithm is just a squence of the logical operations to achieve the purpose fixed at the first, and the basic operations it uses is the most important to watch out.

For example, the computer only has simple operations, like data moving, data processing, data storage and control. The produres that we use these simple operations to achieve the complex mathmatical operations, like addition, multiplication, modulus, and so on, are the algorithms. However, if a program language bases on the basic math operations, we also call the programs designed by the sentences to achieve some features the algorithms. Just like Matlab, to design the Eigendecomposition, we just use the matrix methods provided by the matlab to form the corresponding algorithm.

---

## Different Programming Language

Although $G_b$ has many forms and can be designed in distinct programming language by the algorithms yourself, some programming languages have designed $G_b$s for ease of use.

Like Java, in the `java.util` package, there are `ArrayList`, `HashSet`, `HashMap` and so on. All these are part of something bigger - the **Java Collection Framework**.

The Java Collection Framework provides a set of **interface** (like `List`, `Set` and `Map`) and a set of **classes** (`ArrayList`, `HashSet`, `HashMap`, etc.) that implement those interfaces.

All of these are in `java.util` package, which are used to store, search, sort, and organize data more easily - all using standardized methods and partters.

> **Tip:** Think of the Collections Framework as a toolbox.
> Interfaces like `List` define what tools can do, and calsses like `ArrayList` are the actual tools that do the work.

### Core Interfaces in the Collections Framework

| **Interface** | **Common Classes** | **Description** |
| :---: | :---: | :--- |
| `List` | `ArrayList`, `LinkedList` | Ordered collection that allows duplicates |
| `Set` | `HashSet`, `TreeSet`, `LinkedHashSet` | Collection of unique elements |
| `Map` | `HashMap`, `TreeMap`, `LinkedHashMap` | Stores key-value pairs with unique keys |

### Overview of Classes

| **Interface** | **Class** | **Description** |
| :---: | :---: | :--- |
| **List** | `ArrayList` | Resizable array that maintains order and allows dupllicates |
| | `LinkedList` | List with fast insert and remove operations |
| **Set** | `HashSet` | Unordered collection of unique elements |
| | `TreeSet` | Sorted set of unique elements (natural order) |
| | `LinkedHashSet` | Maitains the order in which elements were inserted |
| **Map** | `HashMap` | Stores key/value pairs with no specific order |
| | `TreeMap` | Sorted map based on the natural order of keys |
| | `LinkedHashMap` | Maintains the order in which keys were inserted |

> Use `List` classes when you care about order, you may have duplicates, and want to access elements by index.
>
> Use `Set` classes when you need to store unique values only.
>
> Use `Map` classes when you need to store pairs of keys and values, like a name and its phone number.

---

## $G_b$

I will show this by Java programming language, because I am reviewing it.

The `List` interface is part of the $\underline{\text{Java Collection Framework}}$ and represents an **ordered collection** of elements.

You can access elements by their index, add duplicates, and maitain the insertion order.

Since List is an interface, you cannot create a List object directly. Instead, you use a class that implements the `List` interface, such as:
*   `ArrayList` - like a resizable array with fast random access
*   `LinkedList` - like a train of cars you can easily attach or remove

> Use `List` when you care about order, you may have duplicates, and want to access elements by index.

### Management Methods provided by `List`

| Method | Description |
| :---: | :--- |
| `add()` | Adds an element to the end of the list |
| `get()` | Returns the element at the specified position |
| `set()` | Replaces the element at the specified position |
| `remove()` | Removes the element at the specified position |
| `size()` | Returns the number of elements in the list |

As we see, the $G_a$ is just part of the management methods. The inputs into $G_a$ are contents ($\mathbb{A}$) and postions ($\mathbb{B}$) (maybe ommited), but the outputs ($\mathbb{B}$) generated by $G_b$ are positions only, into which no inputs ($\emptyset$).

> Remember that the CACHE is important to display the standard OUTPUT.
> Try twice and more.
> By the way, whether finish `ctrl+s` is also influence to it.

### List versus. Array

| **Array** | **List** |
| :---: | :---: |
| Fixed size | Dynamic size |
| Fast performance for raw data | More flexible and feature-rich |
| Not part of Collections Framework | Part of the Collections Framework |

### Java ArrayList
**Key Points:**
1.  Resizable
2.  `java.util` package and implements the `List` interface
3.  can be Modified easily, different from the build-in array

### Java LinkedList
**How does the LinkedList works?**
The `LinkedList` stores its elements in "containers". The list has a link to the first container and each container has a link to the next container in the list. To add an element to the list, the element is placed into a new container and that container is linked to one of the other containers in the list.

However, the `ArrayList` class has a regular array inside it. When an element is added, it is placed into the array. If the array is not big enough, larger array is created to replace the old one and the old one is removed.
So, the key difference between `LinkedList` and `ArrayList` is the method to build the place to store the data.

**WHEN TO USE?**
Use an `ArrayList` for storing and accessing data, and `LinkedList` to manipulate data.

**The Special Methods for `LinkedList`：**

| **Method** | **Description** |
| :---: | :---: |
| `addFirst()` | Adds an element to the beginning of the list |
| `addLast()` | Adds an element to the end of the list |
| `removeFirst()` | Remove an element from the beginning of the list |
| `removeLast()` | Remove an element from the end of the list |
| `getFirst()` | Get the element at the beginning of the list |
| `getLast()` | Get the element at the end of the list |

**The `var` Keyword**
```java
LinkedList<String> cars = new LinkedList<String>();

var bikes = new LinkedList<String>();
```

### The List Interface
**Note:** `List` is an interface, but `LinkedList` is an object, which is implemented from the `List`.
```java
import java.util.List;
import java.util.LinkedList;

List<String> cars = new LinkedList<String>();
```

---

### Java Set
The `Set` interface is part of the $\underline{\text{Java Collections Framework}}$ and is used to store a collection of **unique elements**.

**Key Points:**
1.  **not allow duplicates**
2.  not preserve the order of elements (unless `TreeSet` and `LinkedHashSet`)

Common classes that implement `Set`:
-   `HashSet` - fast and unordered
-   `TreeSet` - sorted set
-   `LinkedHashSet` - ordered by insertion

> **Tip:**
> 1. Use a `Set` when you need to store unique values only.
> 2. **Use the mistakes that complier tells to you.**

#### Management Method provided by `Set`

| **Method** | **Description** |
| :---: | :---: |
| `add()` | Adds an element **if it's not already in the set** |
| `remove()` | Removes the element from the set |
| `contains()` | Checks if the set contains the element |
| `size()` | Returns the number of elements |
| `clear()` | Removes all elements |

#### Set versus. List

| **List** | **Set** |
| :---: | :---: |
| Allows duplicates | Does not allow duplicates |
| Maintains order | Does not guarantee order |
| Access by index | No index-based accesss |

### Java HashSet
A `HashSet` is a collection of elements where every element is **unique**. It's part of the `java.util` package and implements the `Set` interface.

### Java TreeSet
A `TreeSet` is a collection that stores unique elements **in sorted order**. It's part of the `java.util` package and implements the `Set` interface.

> **Tip:** Unlike `HashSet`, which has no order, `TreeSet` keeps its elements sorted automatically.

#### HashSet versus. TreeSet

| **Feature** | **`HashSet`** | **`TreeSet`** |
| :---: | :---: | :---: |
| Order | No guaranteed order | Sorted (natural order) |
| Order | No allowed | Not allowed |
| Performance | Faster (no sorting) | Slower (due to sorting) |

> **Tip:** `HashSet` is fast, but `TreeSet` can sort elements.

### Java LinkedHashSet
A `LinkedHashSet` is a collection that stores **unique elements** and **remembers the order they were added**. It's part of the `java.util` package and implements the `Set` interface.

> **Tip:** Use `LinkedHashSet` when you want a set that does not allow duplicates and keeps the original insertion order.

| **Feature** | **`HashSet`** | **`LinkedHashSet`** |
| :---: | :---: | :---: |
| Order | No guaranteed order | Insertion order preserved |
| Duplicates | Not allowed | Not allowed |
| Performance | Faster | Slightly slower (due to order tracking) |

---

### Java Map
The `Map` interface is a part of the $\underline{\text{Java Collections Framework}}$ and is used to store **key value pairs**.
A `Map` is useful when you want to associate a key (like a name or ID) with a value (like an age or description).

**Common classes that implement `Map`:**
-   `HashMap` - fast and unordered
-   `TreeMap` - sorted by key
-   `LinkedHashMap` - ordered by insertion

> **Tip:** Use a `Map` when you want to associate values with unique keys, like storing user IDs with names.

#### Management Method provided by Map

| **Method** | **Description** |
| :---: | :---: |
| `put()` | Adds or updates a key-value pair |
| `get()` | Returns the value for a given key |
| `remove()` | Removes the key and its value |
| `containsKey()` | Checks if the map contains the key |
| `keySet()` | Returns a set of all keys |

#### Map versus. Set versus. List
| **Feature** | **List** | **Set** | **Map** |
| :---: | :---: | :---: | :---: |
| Duplicates | Yes | No | Keys:No;Values:Yes |
| Stores key-value pairs | No | No | Yes |
| Maintains order? | Yes | No (unless using TreeSet or LinkedHashSet) | No (unless using TreeMap or LinkedHashMap) |

#### Create a HashMap
Create a `HashMap` object called `capitalCities` that will store `String` keys and `String` values:
```java
import java.util.HashMap; // import the HashMap class

HashMap<String, String> capitalCities = new HashMap<>();
```
Now you can use methods like `put()` to add key/value pairs, `get()` to retrieve a value by key, and `remove()` to delete an entry - all by using keys instead of index numbers.

**Add Items**
```java
// Main.java
import java.util.HashMap;

public class Main{
    public static void main(String[] args) {
        // Create a HashMap object called capitalCities
        HashMap<String, String> capitalCities = new HashMap<String, String>();

        // Add keys and values (Country, city)
        capitalCities.put("England", "Londaon");
        capitalCities.put("India", "New Dehli");
        capitalCities.put("Austrilia", "Wien");
        capitalCities.put("Norway", "Oslo");
        capitalCities.put("Norway", "Oslo");
        capitalCities.put("USA", "Washington DC");

        System.out.println(capitalCities);
    }
}
```

**Access an Item**
```java
capitalCities.get("England");
```

**Remove an Item**
```java
capitalCities.remove("England");
```
```java
capitalCities.clear();
```

---

## $G_a$

### Java List Sorting

### Java HashMap
A `HashMap` stores items in **key/value pairs**, where each key maps to a specific value. It's part of the `java.util` package and implements the `Map` inter face. Instead of accessing elements by an index (like with ArrayList), you use a **key** to retrieve its associated **value**.

A `HashMap` can store many different combinations, such as:
-   `String` keys and `Integer` values
-   `String` keys and `String` values

```java
// Main.java
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    pulic static void main (String[] args) {
        var cars = new ArrayList<String>();
        cars.add("Volvo");
        cars.add("BWM");
        cars.add("Ford");
        cars.add("Mazda");

        Collections.sort(cars);

        for (String i : cars) {
            System.out.println(i);
        }
    }
}
```

No matter how to sort something, once there is a management method, which can pick up an element `A` and paste it to the other position where the element `B` disappears because of the action, we can create a variable `temp` to store `A` temporarily and use the method twice, first to store `A` in temp,then put `B` on the position of `A`, then to put `A` in `temp` on the postion where `B` first occurs.

```java
// Main.java
import java.util.ArrayList;

public class Main {
    public static void main (String[] args) {
        var cars = new ArrayList<String>();
        cars.add("Volvo");
        cars.add("BWM");
        cars.add("Ford");
        cars.add("Mazda");

        String temp = cars.get(0);

        System.out.println(cars);

        cars.set(0, cars.get(1));
        cars.set(1, temp);
        cars.set(1, cars.get(2));
        cars.set(2, temp);
        cars.set(2, cars.get(3));
        cars.set(3, temp); 

        for (String i : cars) {
            System.out.println(i);
        }
    }
}
```

Be careful that the `"Volvo"` is just the biggest, if you write the `"Ford"` to the `"ford"`, you must to create a new variable `temp_new` to simulate the action of `Collections.sort`.

```java
// Main.java
import java.util.ArrayList;

public class Main {
    public static void main (String[] args) {
        var cars = new ArrayList<String>();
        cars.add("Volvo");
        cars.add("BWM");
        cars.add("ford"); // "Ford" is fixed to the "ford"
        cars.add("Mazda");

        String temp = cars.get(0);

        System.out.println(cars);

        cars.set(0, cars.get(1));
        cars.set(1, temp);
        cars.set(1, cars.get(3));
        cars.set(3, temp);

        temp_new = cars.get(2);

        cars.set(2, cars.get(3));
        cars.set(3, temp_new); 

        for (String i : cars) {
            System.out.println(i);
        }
    }
}
```

**Reverse the Order**
use `reverseOrder()`:

```java
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        var cars = new ArrayList<String>();
        
        cars.add("Volvo");
        cars.add("BWM");
        cars.add("Ford");
        cars.add("Mazda");

        Collections.sort(cars, Collections.reverseOrder());
        
        for (String car: cars) {
            System.out.println(car);
        }
    }
}
```