# This will be re-written in C, Python is just good for prototyping
from time import sleep as sleep

speed = 400
tilt = 90
tilt = tilt - 90
if tilt != 0:
    xspeed = 400/(90/tilt)
else:
    xspeed = 0

yspeed = speed - xspeed

x = 0
y = 100

while True:
    x += xspeed
    y += yspeed
    print(f"x: {x}. y: {y}")
    sleep(0.5)
