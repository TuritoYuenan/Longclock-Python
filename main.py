from interactions import *
from dotenv import dotenv_values
import longclock

env = dotenv_values('secrets.env')

robot = Client(
	token = env['TOKEN'],
	debug_scope = env['SERVER']
)

timeFmt: str = '%X'
dateFmt: str = '%d of %B, %Y'

@slash_command(name='longtime', description='Current Longtime of a location')
@slash_option(name='city', description='City', opt_type=OptionType.STRING, required=True)
@slash_option(name='country', description='Country the city is in', opt_type=OptionType.STRING, required=True)
async def longtime(ctx: SlashContext, city: str, country: str):
    loc = longclock.geocode(country, city)
    ltime = longclock.clock(loc['longitude'])

    message = Embed(
        title = f'{ltime.strftime(timeFmt)} | {ltime.strftime(dateFmt)}',
        description = f'Longtime of {loc["name"]}, {loc["country"]}',
        author = EmbedAuthor('Longclock Robot'),
        footer = EmbedFooter('2023 Turito Yuenan | Non-commercial'),
        color = 0xFF0000
	)

    await ctx.send(embeds=message)

@listen()
async def on_ready(): print('Ready! Serving Discord server', env['SERVER'])
"Announce when ready"

robot.start()
"Activate the robot"
