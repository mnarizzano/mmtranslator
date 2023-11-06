import re

kiss2_file = open("C:/Users/kla19/AppData/Local/Programs/Python/Python39/SE_23/circuits/acm-sigda-mcnc/bbara.txt")

pattern = re.compile('[0-9]+')
n_inputs = kiss2_file.readline()
n_outputs = kiss2_file.readline()
n_transitions = kiss2_file.readline()
n_states = kiss2_file.readline()
 
n_inputs = pattern.findall(n_inputs)[0]
n_outputs = pattern.findall(n_outputs)[0]
n_transitions = pattern.findall(n_transitions)[0]
n_states = pattern.findall(n_states)[0]
print("number of inputs: " + n_inputs)
print("number of outputs: " + n_outputs)
print("number of transitions: " + n_transitions)
print("number of states: " + n_states)

lines_with_blanks = kiss2_file.readlines()
lines = []
for l in lines_with_blanks:
    lines.append(l.rstrip("\n"))
for l in lines:
    print(l)
pattern = re.compile("st[0-9]+ st[0-9]")
digit_pattern = re.compile("[0-9]")

state_transition = list()
input = list()
output = list()
input_pattern = re.compile("^[0-9-]+")
output_pattern = re.compile("[0-9-]+$")
for l in lines:
    state_transitions_string = pattern.findall(l)
    print(state_transitions_string)
    d = digit_pattern.findall(state_transitions_string[0])
    state_transition.append(d)
    input.append(input_pattern.findall(l))
    output.append(output_pattern.findall(l))
    #sstate_transition.append( + "->" + )
for st in state_transition:
    print(st) 
print("-------------------------")
for i in input:
    print(i)   
for o in output:
    print(o)

dot_format = list()
for i in range(int(n_transitions)):
    print(state_transition[i][0])
    print(state_transition[i][1])
    print(input[i])
    print(output[i])
    dot_format.append(state_transition[i][0]+ " -> " + state_transition[i][1] + 
            ' [label="' + input[i][0] + "/" + output[i][0] + '"]')
for df in dot_format:
    print(df)
