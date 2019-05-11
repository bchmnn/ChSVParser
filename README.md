# ChSVParser - Char Separated Values Parser

Like CSVParser but for any character or string as separator.

## Usage

The constructor of the class `ChSVParser` has two optional
parameters:
* `sep = ","` - separator for elements
* `term = "\n"` - separator for rows

```kotlin
val text = "Foo,Bar|Baz,Boz"
val content = ChSVParser(term = "|").parse(text)
// content.rows[0].elems = {"Foo", "Bar"}
// content.rows[1].elems = {"Baz", "Boz"}
```

Same sep and term throws a `IllegalArgumentsException`:
```kotlin
ChSVParser("-", "-")
```

## Upcoming
* toString method - generates ascii table
* toCsv method - generates csv string of content
* toExcel method - generates string readable by excel
* ...

## Contributor
[Jacob Bachmann](https://github.com/bchmnn)