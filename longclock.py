from datetime import datetime, timedelta, timezone
from dotenv import dotenv_values
import requests

URL = "https://api.api-ninjas.com/v1/geocoding?country={}&city={}"
APIkey = dotenv_values("secrets.env")["APIKEY"]
Header = { "X-Api-Key": APIkey }

####################################################


def geocode(country: str, city: str) -> list[object]:
	"Geocode a location based on the city and country"

	response = requests.get(
		url=URL.format(country, city), headers=Header # type: ignore
	)

	if response.status_code == requests.codes.ok:
		output = response.json()

		print(output)
		return output

	else:
		print("Error:", response.status_code, response.text)
		raise requests.HTTPError


####################################################


def clock(longitude: float) -> datetime:
	"Return time based on longitude"

	offset: timedelta = timedelta(hours=round(longitude / 15))
	longtime = datetime.now(timezone(offset))

	return longtime


####################################################

UTCtime = datetime.now(timezone.utc)
debugTimeFormat: str = "%Y-%m-%d %H:%M:%S"

print(UTCtime.strftime(debugTimeFormat))
print(clock(0).strftime(debugTimeFormat))
