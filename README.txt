Summary
=======

There are two sets of benchmarks in the KISS2 format:

  1. The ACM/SIGDA circuit benchmarks (formerly known as MCNC). These are
     benchmarks from the LGSynth89,91,93 workshops. All are (partial)
     specifications of circuit behaviour. Total: 54 specs.

  2. The ISM benchmarks. These are a collection of benchmarks from several
     papers, collected for the ISM (implicit state minimization) tool. These
     state machines are not from circuits and may have an alphabet size which
     is not a power of two (which is not supported in KISS2, so it is specified
     with comments). Total: 43 specs.

All specifications are deterministic, may be partial, may include unreachable
states, may omit an initial state. They specify output on transitions.



Details for 1
=============

The benchmarks (also including other, non-fsm benchmarks), the history of the
workshops, and the format description can be found on the following websites:

 https://people.engr.ncsu.edu/brglez/CBL/benchmarks/Benchmarks-upto-1996.html

 https://ddd.fit.cvut.cz/prj/Benchmarks/

The first websites states that we should refer to the benchmarks as ACM/SIGDA
and not MCNC (which is how the second website refers to it).

We list the benchmarks below with references. The workshops also removed
benchmarks. But I only list additions. There are a few sequential benchmarks
in the BLIF format; those are not included here.

These benchmark have, for example, been used in FSM-testing:

 Hierons, Robert M., and Uraz Cengiz Türker. "Incomplete distinguishing
 sequences for finite state machines." The Computer Journal 58.11 (2015):
 3089-3113.


## From the LGSynth89 workshop

 S. Yang. Logic Synthesis and Optimization Benchmarks, Technical Report, MCNC,
 Dec. 1988, published at 1989 MCNC International Workshop on Logic Synthesis.

    bbara      donfile    lion9      scf
    bbsse      ex1        mark1      shiftreg
    bbtas      ex2        mc         sse
    beecount   ex3        modulo12   styr
    cse        ex4        opus       tav
    dk14       ex5        planet     tbk
    dk15       ex6        planet1    train11
    dk16       ex7        s1         train4
    dk17       keyb       s1a
    dk27       kirkman    s8
    dk512      lion       sand


## From the LGSynth91 workshop

 S. Yang. Logic Synthesis and Optimization Benchmarks User Guide Version 3.0,
 Technical Report 1991-IWLS-UG-Saeyang, MCNC.

    pma     s1494   s27     s386    s510    s832
    s1488   s208    s298    s420    s820    tma


## From the LGSynth93 workshop

 K. McElvain. IWLS'93 Benchmark Set: Version 4.0, Distributed as a part of
 IWLS'93 benchmark set, May 1993.

    bbara_bbta



Details for 2
=============

I received the benchmarks personally from Abel Andreas, who in turn got them
from Arlindo Oliveira. The zip I received contained a few duplicate files, I
have removed them. They have been originally collected in the paper:

 T. Kam, T. Villay, R. Brayton and A. Sangiovanni-Vincentelli. A Fully Implicit
 Algorithm for Exact State Minimization. Design Automation, 1994. 31st
 Conference on. IEEE, 1994.

It also included some of the ACM/SIGDA/MCNC benchmarks (see above). I have
removed those from the list below. These benchmarks (or a subset) have been
used in other papers as well:

 J. M. Pena and A. L. Oliveira. A new algorithm for exact reduction of
 incompletely specified finite state machines. IEEE Transactions on Computer-
 Aided Design of Integrated Circuits and Systems 18.11 (1999).

 Abel, Andreas, and Jan Reineke. "MeMin: SAT-based exact minimization of
 incompletely specified mealy machines." Proceedings of the IEEE/ACM
 International Conference on Computer-Aided Design. IEEE Press, 2015.

The set consists of the following benchmarks.


## Asynchronous synthesis

 L. Lavagno, C. W. Moon, R. K. Brayton, and A. Sangiovanni-Vincentelli. Solving
 the state assignment problem for signal transition graphs. The Proceedings of
 the Design Automation Conference, pages 568–572,June 1992.

    alex1               pe-rcv-ifc.fc       pe-send-ifc.fc.m
    intel_edge.dummy    pe-rcv-ifc.fc.m     vbe4a
    isend               pe-send-ifc.fc      vmebus.master.m


## Learning from sequences

 S. Edwards and A. Oliveira. Synthesis of minimal state machines from examples
 of behavior. EE290LS Class Project Report, U.C. Berkeley, May 1993.

    fo.16      fo.50      th.25      th.55
    fo.20      fo.60      th.30
    fo.30      fo.70      th.35
    fo.40      th.20      th.40


## Synthesis of interacting FSMs

 H.-Y. Wang and R. K. Brayton. Input don’t care sequences in FSM networks. In
 The Proceedings of the International Conference on Computer-Aided Design,
 pages 321–328, November 1993.

    ifsm0       ifsm2
    ifsm1       ifsm2ndc


## Worst cases for something

 F. Rubin. Worst case bounds for maximal compatible subsets. IEEE Transactions
 on Computers, pages 830–831,August 1975.

    rubin1200    rubin2250
    rubin18      rubin600


## Randomly generated

 T. Kam, T. Villay, R. Brayton and A. Sangiovanni-Vincentelli. A Fully Implicit
 Algorithm for Exact State Minimization. Design Automation, 1994. 31st
 Conference on. IEEE, 1994.

    e1          e271        e423        ex2.e285
    e2          e285        e608        ex2.e304
    e271.j      e304        ex2.e271    ex2.e423


## One more

There is one more benchmark, unclear where it comes from.

    teste
