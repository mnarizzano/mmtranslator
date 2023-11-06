import pydot 
import re

graphs = pydot.graph_from_dot_file('circuits\sample_folder\example.dot')
graph = graphs[0]

compact_edges = []
for e in graph.get_edge_list():
    compact_edges.append(str(e))
print("EDGES given at the beginning:")
for ce in compact_edges:
    print(ce)

edges = set()
pattern3 = re.compile("[0-1x]+/{1}[0-1x]+")
print("THE EDGE LIST IS:")    
for e in compact_edges:
    if (" or " in e):
        vector1 = e.partition("=")
        root = vector1[0]
        occurences = pattern3.findall(vector1[2])
        print("Occurrencies:")
        for oc in occurences:
            edge = root + '"' + oc + " ]"
            edges.add(edge)
    else:
        edges.add(e)            

print("PROVA")        
for e in edges:
    print(e)      
print("FINE PROVA")
all_info = list()
pattern1 = re.compile("[0-1x]+/{1}[0-1x]+")
pattern2 = re.compile("^[0-9]+ -{1}>{1} [0-9]")
for e in edges:
    all_info.append(pattern1.findall(e)+pattern2.findall(e))

for a in all_info:
    print(a)
# source_destination_states = list()
# pattern2 = re.compile("^[0-9]+ -{1}>{1} [0-9]")
# for t in edges:
#     source_destination_states.append(pattern2.findall(t))

input_signals = list()
output_signals = list()
kiss = list()
input_states_number = 0
output_states_number = 0
transitions_number = 0
states_number = 0
for e in all_info:
        i = ""
        o = ""
        so = ""
        d = ""
        for s in e:    
            if ("/" in s):
                vector = s.partition("/")
                i = vector[0]
                o = vector[2]
            if(" -> " in s):
                vector = s.partition(" -> ")
                so = vector[0]
                d = vector[2]    
        kiss.append(i + " st" + so + " st" + d + " " + o)   
kiss = sorted(kiss)
for k in kiss:
    print(k)