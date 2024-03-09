import re

import sys
 
fileToUpdate = sys.argv[1]

print(fileToUpdate)

nodeOpenName="22222"

nodeCloseName="44444"

def replaceCSSIncludes():

	markerBegin="<!-- html / including / styling / begin -->"

	markerEnd="<!-- html / including / styling / end -->"

	with open('templates/html-includes-styling.template') as templateFile:

		substitutionContent = templateFile.read()

	with open(fileToUpdate) as targetSubstitutionFile:

		s = targetSubstitutionFile.read()

	ddd=s

	ddd=re.sub(markerBegin, markerBegin+nodeOpenName, ddd, flags=re.DOTALL)

	ddd=re.sub(markerEnd, nodeCloseName+markerEnd, ddd, flags=re.DOTALL)

	ddd=re.sub(nodeOpenName+".*"+nodeCloseName, substitutionContent, ddd, flags=re.DOTALL)

	f = open(fileToUpdate, "w")
	
	f.write(ddd)
	
	f.close()

def replaceJavascriptIncludes():

	markerBegin="<scripting>"

	markerEnd="</scripting>"

	with open('templates/html-includes-scripting.template') as templateFile:

		substitutionContent = templateFile.read()

	with open(fileToUpdate) as targetSubstitutionFile:
		s = targetSubstitutionFile.read()

	ddd=s

	ddd=re.sub(markerBegin, markerBegin+nodeOpenName, ddd, flags=re.DOTALL)

	ddd=re.sub(markerEnd, nodeCloseName+markerEnd, ddd, flags=re.DOTALL)

	ddd=re.sub(nodeOpenName+".*"+nodeCloseName,substitutionContent,ddd,flags=re.DOTALL)

	f = open(fileToUpdate, "w")
	
	f.write(ddd)
	
	f.close()

def updateSideBarDesktop():

    markerBegin="<!-- html / sidebar / desktop / begin -->"

    markerEnd="<!-- html / sidebar / desktop / end -->"

    with open('templates/navigation-sidebar-desktop.template') as templateFile:
        substitutionContent = templateFile.read()

    with open(fileToUpdate) as targetSubstitutionFile:

        s = targetSubstitutionFile.read()

    ddd=s

    ddd=re.sub(markerBegin, markerBegin+nodeOpenName, ddd, flags=re.DOTALL)

    ddd=re.sub(markerEnd, nodeCloseName+markerEnd, ddd, flags=re.DOTALL)
    ddd=re.sub(nodeOpenName+".*"+nodeCloseName,substitutionContent,ddd,flags=re.DOTALL)
    f = open(fileToUpdate, "w")
    f.write(ddd)
    f.close()

def updateSideBarMobile():

    markerBegin="<sidebar.mobile>"

    markerEnd="</sidebar.mobile>"

    with open('templates/navigation-sidebar-mobile.template') as templateFile:

        substitutionContent = templateFile.read()

    with open(fileToUpdate) as targetSubstitutionFile:

        s = targetSubstitutionFile.read()

    ddd=s

    ddd=re.sub(markerBegin, markerBegin+nodeOpenName, ddd, flags=re.DOTALL)

    ddd=re.sub(markerEnd, nodeCloseName+markerEnd, ddd, flags=re.DOTALL)

    ddd=re.sub(nodeOpenName+".*"+nodeCloseName,substitutionContent,ddd,flags=re.DOTALL)

    f = open(fileToUpdate, "w")

    f.write(ddd)

    f.close()

###################################################################
##
## driver
##
###################################################################

replaceCSSIncludes()

##replaceJavascriptIncludes()

updateSideBarDesktop()

#updateSideBarMobile()
