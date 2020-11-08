#include <iostream>
#include <cstdlib>
#include <unistd.h>

int main(){
	int speed=400; // Meters per second
	speed = speed / 2;
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
		std::cout << "x: " << x << " y: " << y << std::endl;
		usleep(500000);
	}
}

