# Longitude Time

This is a clock app that tells time based on the user's longitude

## Concept

- Time zones were originally determined by longitude (and they still do!).
- But if you look at a time zone map, you'll notice most time zone boundaries got bent around country borders, or just pierced through completely.
- This is because many countries choose to observe one or a few time zones for uniformity and simplicity.
- It's fine, but it also means time in many places are not as correct as we thought (not even to mention DST).
- **Longitude Time** as an app provides an insight on what each location's realtime is.

## How it works

1. Longitude Time receives your location input consisting of your city and country.
2. The city and country inputs are sent to a Geocode API to receive the longitude.
3. The received longitude is divided by 15 and rounded to give your location's time offset.
4. Your location's longitude time is then calculated by adding the offset to the current UTC/GMT time
