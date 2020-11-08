fn main(){
    use std::{thread, time};
    
    let half_second = time::Duration::from_millis(500);
    let speed = 400; // Meters per second
    speed = speed/2;
    let mut tilt = 90;
    let mut xspeed=0;
    let mut yspeed=0;
    let mut x=0;
    let mut y=100;
    tilt = tilt - 90;
    if tilt != 0{
        xspeed = speed/(90/tilt);
    } 
    yspeed = speed - xspeed;
    
    for n in 0..10{
        x += xspeed;
        y += yspeed;
        println!("x: {0} y: {1}", x, y);

        thread::sleep(half_second);
    }
}

