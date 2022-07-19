#!/usr/bin/perl
# Incase you want to run from linux make sure to have dependecies^
# Using a hash

my @chars = ( "A" .. "Z", "a" .. "z" ); # alphabet declaration
my %data;    #input initialized
my $start = time;    #clock start
for ( $a = 0 ; $a < 100 ; $a = $a + 1 ) {    #enter name and age for 500 times
    my $name;
    my $age;
    $name .= $chars[ rand @chars ] for 1 .. 3;  #generate a 3 letter name
    $age = int( rand(100) );    #generate a random age
    $data{$name} = $age;    #add the name and age to hash
}

my $duration = time - $start;             #calculate total execution time
print "Execution time: $duration s\n";    #display the total execution time
