//Mishael Gonzalez
//725007329
//CSCE 315-100
//Due: June 5, 2017
//project1.cpp
#include <iostream>
#include <cmath>
#include <ctime>
using namespace std;
/*
#include <iostream>
#include <cmath>

using namespace std;


void __attribute__((weak)) check(float alt_sigmoid(float x));

//default check function - definition may be changed - will not be graded
void __attribute__((weak)) check(float alt_sigmoid(float x)) {
	if (alt_sigmoid(0.0f) >= 0.49f &&
		alt_sigmoid(0.0f) <= 0.51f)cout << "PASS\n";
	else cout << "FAIL\n";
	return;
}

//change this definition -  will be graded by a different check function
float my_sigmoid(float x) {
	// through testing (using -Ofast) got good times where this 
	// function is at least two times faster. However, with out -Ofast 
	// I got some "interesting" running times
	
	if (x >= -1.22f && x <= 1.22f) { // piecewise function of a line between
		return .23105f * x + .50f; //  x = [-1.22, 1.22]
	}
	else{ // use limit approximation of e^x
		// make n  and power of 2
		float e = (1 + (x/32.0f));
		
		e *= e;
		e *= e; //manualy multiply instead of using a for loop
		e *= e; //to decrease running time even more
		e *= e;
		e *= e;
		return e / (e + 1); // use some algebra to make the equation
							// use only 1 division.
	}
}


//Do not change this function
int main() {
	check(my_sigmoid);
	return 0;
}
*/
float my_sigmoid_exact(float x) {

	return 1.0f / (1.0f + expf(-x));
}
void check(float alt_sigmoid(float)) {

	
	float x;
	float test = 0;
	int times_to_run = 1000000;

	//cout << "clock before : " << clock() << endl;

	clock_t timer = clock();

	for (int i = 0; i < 1000000; i++) {
		x = i * 8.0f / 1000000 - 4.0f;
		test += x;
	}

	float overhead = clock() - timer;

	for (int i = 0; i < times_to_run; i++) {
		x = i * 8.0f / times_to_run - 4.0f;
		test+= my_sigmoid_exact(x);
	}

	timer = clock() - timer;
	timer = ((timer * 1000) / (CLOCKS_PER_SEC));
	cout << "Time of running sigmoid exact: " << timer << endl;

	//cout << "clock after : " << clock() << endl;

	cout << "+++++++++++++++++"  << endl;

	cout << "+++++++++++++++++" << endl;

	timer = clock();
	for (int i = 0; i < times_to_run; i++) {
		x = i * 8.0f / times_to_run - 4.0f;
		test += alt_sigmoid(x);
	}
	timer = clock() - timer;
	timer = ((timer * 1000) / (CLOCKS_PER_SEC));
	cout << "Time of running the alternate sigmoid: " << timer << endl;

	cout << "Correctness check" << endl;
	for (int i = 0; i < times_to_run; i++) {
		float x = i * 8.0f / times_to_run - 4.0f;
		float difference = my_sigmoid_exact(x) - alt_sigmoid(x);
		if (difference < -.01 || difference > 0.01) {
			cout << "failed test at x = " << x << endl;
			cout << "Expected: " << my_sigmoid_exact(x) << endl;
			cout << "Got: " << alt_sigmoid(x) << endl;
			return;
		}
	}
	cout << "Correctness test passed" << endl;
	cout << test << endl;
}
float my_sigmoid(float x) {
	// through testing (using -Ofast) got good times where this 
	// function is at least two times faster. However, with out -Ofast 
	// I got some "interesting" running times
	
	if (x >= -1.22f && x <= 1.22f) { // piecewise function of a line between
		return .23105f * x + .50f; //  x = [-1.22, 1.22]
	}
	else{ // use limit approximation of e^x
		// make n  and power of 2
		float e = (1 + (x/32.0f));
		
		e *= e;
		e *= e; //manualy multiply instead of using a for loop
		e *= e; //to decrease running time even more
		e *= e;
		e *= e;
		return e / (e + 1); // use some algebra to make the equation
							// use only 1 division.
	}
}
int main() {
	check(my_sigmoid);
	return 0;
}