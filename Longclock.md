## Concept

Longclock is a clock app that tells time based on longitude instead of depending on the current UTC system. This will **rule out** weird geopolitical anomalies such as China's 1 Time Zone, moving time zones or Daylight Saving Time in general.

## Algorithm

Consists of 2 parts: Long and Clock. The app will calculate how many hours is different from the location to the (default) UTC time zone - called the "offset" - and add the offset to a UTC time object to show the Longtime.

### Long: Get the location's `UTC_offset`

1. User inputs their location: `country` and `city`
2. Query the `country` and `city` to get its `longitude`
3. Calculate `longitude` / 15
4. Output the rounded result as `UTC_offset`

> By then, output the calculated `Time Zone`. This variable will be in `Number/Integer` format, which will be how many hours to offset from the central UTC+0 Time Zone (Greenwich Mean Time)

### Clock: Output the location's `Longtime`

The time told by the Longclock will be called `Longtime`.
1. Create two UTC time object P (primaryTime) and C (controlTime)
	1. With C, use the location's default UTC system time zone
	2. With P, add in the `UTC_offset` to P
2. Display both time objects on the UI