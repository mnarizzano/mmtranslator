### First Meeting Notes

Date: 21/03/2023

Participants: Head of MNcomp(Head), an OldChip MM designer(OldDesigner), a NewChip MM designer(NewDesigner),a chip loader(Loader)

Notes:

**What is the main problem?** - **Head**:The main problems is that The MNcomp employees do not know the NewChip Design Tools and the Head of MNcomp does not think is a good idea to spend a lot of money to teach the NewChip Design tool to its employees. 

**Why not to hire new Employees that already have the knowledge?**. - **Head**: We can not fire all the MNcomp Employees since we still have an important part of business using old chips. On the other hand we can not afford to have double people, one with the knowledge of the OldChip Design Tools and one with the knowledge on the NewChip Design Tool. The best would be to teach to the MNcomp Empployees the new tool. However this could have some drawbacks: first we have a lot of MM already designed with Oldchip Designer tool that in principle can be reused on the new chips but they must be re-drawed using NewChip Designer Tools, so waste of Time, and second what if tomorrow we want to expand our business with a new chip with different output format? should we learn anohter tool? It is not affordable. 

**What is the Kiss2 format?** **Loader** : is a new test file format describing a MM. You can find a reference to its syntax [here]() **Is there anny difference between Mealy Machines written in dot format from the ones written in Kiss2 format?** From a semantic point of view there are not differences between the same MM written in dot format and Kiss2 format. They differ only from the syntax point of view. A node is a node in both formats, so are also transitions, signals and all the other part of the MM machine.  

**MM has requirements for the Design?** **OldDesigner** Of course when we start to design a MM we have some requirements similar to the requirements used in Requirements Engineering. However since we are describing some embedded systems behaviours we use a formal language to describe the MM funcionality. Have a look at this [reference](mm.pdf).

**Which Tools are necessary for the Deisgn?** **Head** : two different tools can be used one for the design of old chips (OldChip Designer) and one for the design of nwe chips (NewChip Designer Tool) 

**Which are the Tools limit?** **OldDesigner/NewDesigner** There are some features that can be added to both the tools, however we would to talk about the **feature that we need**. For example as used we would like to be able to load a text file describing MM in dot/Kiss2 Format, modify it, and then save it into a dot/Kiss2 text File.  We would also like to have the same features of the OldDesigner tool since it looks more friendly and easy to use and the majority of the Company Employees already know it. 

**Which interfaces would you prefer?** **Head** Given the fact that most of the Employees know the OldChip Designer Tool, probably this would be the preferred one.

**Which frameworks/Languages/Tools are used in your company?** **Head** We are not software developer, so we can not use it. However if the tools can be used in a remote way, may be having some place around the net would be great. For example if an Employee can access the tool chain remotely from his home would be great.

**Do we have compatibility issues?** **OldDesigner** The designer tool runs on simple desktop PC, however the MM text file can be very large if we are designning a very complex system.

**Can the Designer tools provided by the two company be modified by adding external plugins?** **New Designer** : Both the designer tools are propetary software, so only executables are provided to us. **Did you ever ask for a plugin to the company** **Head** - Yes in the past we sent some improvements that could have been done to the OldChip Company, and some of them were present in the new version. However it tooks some years to have them and not all. Before deciding to get the new chips we asked to the NewChip Company if they ever planned to provide a way to save/load dot MM. They answer that they never plan and that they are now in the process of considereing. But since a couple of month we did not have any precise answer.



Who are the people involved in the Design process?

