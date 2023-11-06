import graphviz

dot = graphviz.Digraph(comment="The Round Table")
dot.node('A', 'King Arthur')
dot.node('B', 'Sir Bevedere The Wise')
dot.node('L', 'Sir Lancelot The Brave')

dot.edges(['AB','AL'])
dot.edge('B','L', constraint="False")

print(dot.source)

import pydot

dot_string = """graph graph_0 {
    bgcolor="yellow";
    a [label="Foo"];
    b [shape=circle];
    a -- b -- c [color=blue];
}"""

# graphs = pydot.graph_from_dot_data(dot_string)
# graph_0 = graphs[0]
# print(graph_0)
# leaves = {n.get_name() for n in graph_0.get_nodes()}
# string_leaves = (str(leaves))
# # string_leaves = string_leaves.strip('"{')
# # string_leaves = string_leaves.strip('"}')


graphs = pydot.graph_from_dot_file('circuits\sample_folder\example.dot')
graph = graphs[0]
leaves = {n.get_name() for n in graph.get_nodes()}
string_leaves = (str(leaves))
string_leaves = string_leaves.replace('{', "")
string_leaves = string_leaves.replace('}', "")
string_leaves = string_leaves.replace("'", "")
string_leaves = string_leaves.replace(" ", "")
string_leaves = string_leaves.split(",")
for l in string_leaves:
    print(l)
number_of_nodes = len(string_leaves)
print(f"The number of nodes is: {number_of_nodes}")


edges = []
string_edges = []
for e in graph.get_edge_list():
    edges.append(e)
print("THE EDGE LIST IS:")    
for e in edges:
    print(e)
    string_edges.append(str(e))
# for s in string_edges:
#     print(s)
input_node = []
str_edges = []
for e in edges:
    str_edges.append(str(e))
#for e in str_edges:
    #print(e)
input_nodes_sequence = []
output_nodes_sequence = []
input_nodes = {"0"}
output_nodes = {"0"}
transitions = []
for e in str_edges:
    vector = e.split(" ")
    #print(vector[4])    
    input_nodes_sequence.append(vector[0])
    output_nodes_sequence.append(vector[2])
    input_nodes.add(vector[0])
    output_nodes.add(vector[2])
    transitions.append(vector[4])
# print("Input nodes are: ")
# for i in input_nodes:
#     print(i)    
# print("Output nodes are: ")
# for o in output_nodes:
#     print(o)   
# print("Transitions are: ")
raw_input_signals = []
raw_output_signals = []
for t in transitions:
    #print(t)
    start_index = t.find('"')
    end_index = t.rfind('"')
    slash = t.partition("/")
    raw_input_signals.append(slash[0])
    raw_output_signals.append(slash[2])
#print("INPUT SIGNALS")
input_signals = []
for i in raw_input_signals:
    vector = i.partition('"')
    input_signals.append(vector[2])
output_signals = []
for o in raw_output_signals:
    vector = o.partition('"')
    output_signals.append(vector[0])
str_graph = (str(graph))
graph_lines = str_graph.splitlines()
#for l in graph_lines:
    #print(f"These are the graph lines {l}")
graph_lines.pop(0)
states = 0
for l in graph_lines:
    if l.find("->")==-1:
        states+=1
    else: 
        break
#print(states)   


kiss2_translation = []
kiss2_translation.append(f".i {str(len(input_nodes))}")
kiss2_translation.append(f".o {str(len(output_nodes))}")
kiss2_translation.append(f".p {str(len(transitions))}")
kiss2_translation.append(f".s {states}")


for i in range(len(input_nodes)):
    kiss2_translation.append(str(input_signals[i])+ " "+str("st"+input_nodes_sequence[i])+" "+str("st"+output_nodes_sequence[i])+" "+str(output_signals[i])) 

print("The KISS2 equivalent format is :")
for i in kiss2_translation:
    print(i)


#print(graphs[0])



# graph_1 = pydot.Dot('graph_1', graph_type='graph', bgcolor='yellow')

# # Add nodes
# my_node = pydot.Node('a', label='Foo')
# graph_1.add_node(my_node)
# # Or, without using an intermediate variable:
# graph_1.add_node(pydot.Node('b', shape='circle'))

# # Add edges
# my_edge = pydot.Edge('a', 'b', color='blue')
# graph_1.add_edge(my_edge)
# # Or, without using an intermediate variable:
# graph_1.add_edge(pydot.Edge('b', 'c', color='blue'))
# print(graph_1)

