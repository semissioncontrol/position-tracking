#include <unistd.h>
#include <stdio.h>

int main(){
	int speed=400;
	int tilt=90;	
	tilt = tilt - 90;
	int xspeed=0;
	if (tilt != 0) {
		int xspeed = 400/(90/tilt);
	} 

	int yspeed = speed-xspeed;

	int x = 0;
	int y=100;

	for(int i=0; i<10; i++) {
		x = x + xspeed;
		y = y + yspeed;

		printf("x: %d y: %d\n", x, y);
		usleep(500000);
	}
}

