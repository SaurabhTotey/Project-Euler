#!/usr/bin/env python3

import os
import pandas

print(pandas.Series([int(open("output/" + outputFileName, "r").read().split("\n")[1][len("Time: "):-2]) for outputFileName in os.listdir("output")]).describe())
