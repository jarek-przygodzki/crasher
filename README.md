# crasher
A Java EE application  that can trigger Out Of Memory (OOM) error or cause the JVM  to crash with EXCEPTION_ACCESS_VIOLATION 


## Usage

### Trigger OOM
```
POST /api/oom
```


### Crash JVM with  EXCEPTION_ACCESS_VIOLATION 
```
POST /api/jvm-crash
```

### Allocate mememory
```
POST /api/allocate?size=10M
```

### Free all previously allocated memory
```
POST /api/free
```

## Build Instructions
```
mvn clean package -f crasher

```