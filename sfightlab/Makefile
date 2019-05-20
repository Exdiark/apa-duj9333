JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Moveable.java \
	MovingThing.java \
	Ship.java \
	Alien.java \
	Alien2.java \
	Alien3.java \
	AlienHorde.java \
	Aliens.java \
	Ammo.java \
	Bullets.java \
	OuterSpace.java \
	StarFighter.java \
	

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class