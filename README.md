# Kevin Addison

![Java CI with Maven](https://github.com/KevNev19/kevin-addison-itv/workflows/Java%20CI%20with%20Maven/badge.svg)
[![CodeFactor](https://www.codefactor.io/repository/github/kevnev19/kevin-addison-itv/badge)](https://www.codefactor.io/repository/github/kevnev19/kevin-addison-itv)

## ITV Code Challenge

### Question needing to be answered

Given information about streaming video plays, the times when they started and finished, find the maximum number that were playing concurrently.
Write a Java method that accepts an unordered array of play records and returns the maximum concurrency.
You can assume that all end times are after their corresponding start time, that each play lasts at most a few hours, and that all of the plays happen during one calendar month.

```Java
class VideoPlayInfo {
 public Instant startTime;
 public Instant endTime;
}
int getMaximumConcurrentPlays(VideoPlayInfo[] plays) {
 // return maximum concurrency
}
```
### Logic Of Process

Class `VideoPlayInfo` has a start and end time of type `Instant` for every movie that is being streamed.

In order to check for concurrency you need to check that the time the movie started or ended has overlapped with any other movie in the array.

This is done using the following logic

```
startTime1 < endTime2 and startTime2 < endTime1
```

This logic translates the following way:
When the start time of the 1st movie is before the end time of the second movie there is an overlap
AND
When the start time of the second movie is before the end time of the first movie then there is an overlap
