# transformer
Number to English Transform

Overview
--------

The transform project provides two implementations for transforming an input positive or negative integer into English words.
There are two implementations included in the repository. Both approaches employ recurive approaches to solve the problem but the
more simplistic approach has limitations. 

The first, NumberTransformerSimpleStrat relies on the built in Java integer and long types to inspect the input values. This 
inherently limits the size of the input value to the maximum size of the Long type or Long.MAX_VALUE =  9223372036854775807 and  
Long.MIN_VALUE = -9223372036854775808 which is 1 followed by 18 zeros or a Quintillion. 

This second approach, NumberTransformerComplexStrat does not have the same constraint. This approach instead inspects the array 
of input values by determining the number of sets of 3 characters exist in the input String. As it does this, it creates a list 
of data bearing nodes for each group of 3 along with the name those 3 characters represent. For example, if the input value was 
100, only 1 data bearing node would be found and it would simply be handled as 'hundred'. However, in the case of 
100,000, 2 data bearing nodes would be found, one with 100 with a name 'thousand' and one with 000.  After analyzing the inputs
and building up the data node list, the assembler is called to then construct the english tranform.

In both strategies, a set of base reference data is used as lookup references for a min set of values, 1-19,20-90 by tens.  For 
the complex strategy there is also a reference data set containing the names of the large numbers up to novemvigintillion. 

Also, in both cases recursion is used to traverse the data and determine the hundred, tens and ones for each major segment in 
the input number.

Building
--------
The project uses Apache Maven as the build technology and relies only on a few additional libraries, namely Apache Log4j for logging
and Apache Commons-Cli for command line processing.

#To build
$ mvn clean compile 

#To package into an executable jar
$mvn package


#To run unit tests
mvn clean test

Running
-------
The build is configured to create an executable 'fat jar'. Executing the software from the command line is accomplished with
$java -jar target/number-to-english-transformer-1.0-SNAPSHOT.jar 

The help context is retrieved by running with the '-h' or no argument at all.  
$java -jar target/number-to-english-transformer-1.0-SNAPSHOT.jar -h 

Usage context is as follows:
usage: java -jar number-to-english-transformer.jar
 -h,--help                 show help
 -i,--input-number <arg>   the number to be transformed into
                           English(Examples: 9, 23, -345634534223)
 -t,--transformer <arg>    the transform strategy to use, default is
                           'Complex', other option is 'Simple'


The '-t' option provides a mechanism for using the more simplistic implementation, by default the complex strategy is used as it is
not constrained in the same manner as the simple.

The maximum test that performed on the complex strategy was a test with an input value: 2111111000030450123456789987654321000
