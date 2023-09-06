#!/bin/python
#
# Discord bot for Longclock

from interactions import (
	Client,
	Embed, EmbedAuthor, EmbedFooter,
	OptionType, SlashContext,
	slash_command, slash_option, listen
)

from dotenv import dotenv_values
import longclock

env: dict[str, str | None] = dotenv_values("secrets.env")

robot: Client = Client(token=env["TOKEN"], debug_scope=env["SERVER"])

timeFmt: str = "%X"
"Time format"
dateFmt: str = "%d of %B, %Y"
"Date format"


@slash_command(name="longtime", description="Current Longtime of a location")
@slash_option(
	name="city", description="City", opt_type=OptionType.STRING, required=True
)
@slash_option(
	name="country",
	description="Country the city is in",
	opt_type=OptionType.STRING,
	required=True,
)
async def longtime(ctx: SlashContext, city: str, country: str):
	loc = longclock.geocode(country, city)[0]
	ltime = longclock.clock(loc["longitude"])

	message = Embed(
		title=f"{ltime.strftime(timeFmt)} | {ltime.strftime(dateFmt)}",
		description=f'Longtime of {loc["name"]}, {loc["country"]}',
		author=EmbedAuthor("Longclock Robot"),
		footer=EmbedFooter("2023 Turito Yuenan | Non-commercial"),
		color=0xFF0000,
	)

	await ctx.send(embeds=message)


@listen()
async def on_ready():
	"Announce when ready"
	print("Ready! Serving Discord server", env["SERVER"])


robot.start()
