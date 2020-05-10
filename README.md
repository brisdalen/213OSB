This is a project for learning-based games, created in a course for Open Source development.

### Table of contents
* [Motivation](https://github.com/brisdalen/213OSB/blob/master/README.md#motivation)
* [The Developers](https://github.com/brisdalen/213OSB/blob/master/README.md#the-developers)
* [The Interface](https://github.com/brisdalen/213OSB/blob/master/README.md#the-interface)
* [Game 1 - Puzzle Game](https://github.com/brisdalen/213OSB/blob/master/README.md#game-1---puzzle-game)
* [Install & running](https://github.com/brisdalen/213OSB/blob/master/README.md#install--running)
* [Softwares & Technologies](https://github.com/brisdalen/213OSB/blob/master/README.md#Softwares--Technologies)
* [How to contribute](https://github.com/brisdalen/213OSB/blob/master/README.md#How-to-contribute)
* [List of contributors](https://github.com/brisdalen/213OSB/blob/master/README.md#List-of-contributors)
* [Future Plans](https://github.com/brisdalen/213OSB/blob/master/README.md#Future-Plans)
* [License](https://github.com/brisdalen/213OSB/blob/master/README.md#License)
* [Third-party licenses](https://github.com/brisdalen/213OSB/blob/master/README.md#Third-Party-Licenses)

## Motivation
![Motivation (picture)](https://strangecart.com/wp-content/uploads/2020/02/m4.jpg)

Two of our team members have both been part of a programming course as a student teaching assistant. This leads us later to an idea to make learning programming more fun and interactive. Our motivation is to create a platform or software where we help people to learn in creative ways. The goals are to make learning more fun and interactive, and our idea to create a platform where people can use games to teach and learn new things. We intend to gamify the way people pass away knowledge and make it more fun, interactive, and creative through different games.

## The Developers
The initial developers of this project consist of 3 students studying at the University of Agder partaking in a course about Open Source Software development. 
* [brisdalen](https://github.com/brisdalen)
* [JacobHjermann](https://github.com/JacobHjermann)
* [KantaUIA](https://github.com/KantaUIA)/[Kantaa](https://github.com/Kantaaa)

However - following the Open Source philosophy - anyone is encouraged to create issues, develop solutions and send pull requests! See [How to contribute](https://github.com/brisdalen/213OSB/wiki/How-to-contribute) for more information.

## The Interface
In our first meetings we talked about having a centralized interface that would be able to open and run all mini-games and also edit them. If we made very good progress, we talked about making an overview of points and records from all games in a profile-esque way. However, some tasks are harder than they first seem, the first game and the interface itself included, so we decided on a more minimalistic approach for now. Right now there is only one game, so both buttons open the same game, and the same editor for that game. The intention would be that this interface would hold launchers for all mini-games and game editors, like a central hub. Feel free to send pull requests or open issues regarding improvements to the interface.

![The simple interface](https://i.imgur.com/dnvMQU4.png)

The minimalistic interface with game launchers and game editors

![The game editor](https://i.imgur.com/fLoxFqu.png)

The game editor for our puzzle game

## Game 1 - Puzzle Game

## Install & Running
There are 3 simple steps to install this project.
1. Install the latest [Java version](https://www.java.com/en/download/)
2. Install the [Godot game engine](https://godotengine.org/)
3. Clone the 213OSB repository

To run the project, do either A or B:
### A - the GUI way
1. Locate the cloned repository
2. Open the repository and then open the interface folder
3. Double-click the 'interface.jar' file to open the interface
* 3.1 To change the chosen language, open the settings folder and open the config.properties file in your chosen text editor (i.e. notepad or sublime text) and change the value of the language property to 'no', 'en_uk' or any other supported language, depending on which language you want the interface to run.
4. The graphical user interface will now be opened.

### B - the CLI way
1. Open a command terminal of your choosing
2. Locate the cloned repository
3. Change the current directory to the 'interface' folder
4. Run the following command: `java -jar interface`
* 4.1 To change the chosen language, change the current directory to the settings folder, open the config.properties file in your chosen text editor (i.e. vim or nano) and change the value of the language property to 'no', 'en_uk' or any other supported language, depending on which language you want the interface to run.
5. The graphical user interface will now be opened.

## Software & Technologies
### Game engine
![Godot(Picture)](https://godotengine.org/themes/godotengine/assets/logo.svg)
The game engine we are using is an Open Source game engine called [Godot](https://godotengine.org/).
Godot is a game engine that is easy to program, has an innovative
design, and looking good in both 2D and 3D game creation. The platform allowed us to express our ideas and create games.


### Java
![Java(picture)](https://seeklogo.com/images/J/java-logo-41D4155FC3-seeklogo.com.png)

We also use [Java](oracle.com/java/technologies/javase-downloads.html) 11 or higher.
The reason we choose to use Java is that the team feels most comfortable using it since we all have the same background learning the language.

## How to contribute
Now the exciting question everybody is dying to know the answer to: How do I contribute to this wonderful open source project!? You have certainly found the correct wiki page for that!

### Requirements
In order to contribute you must install one or more of the following, depending on which parts of the project you want to contribute to:

* For the interface, you will need to download the Java Development Kit, and that's it. Feel free to use whatever IDE you want. 

* For games, you will need to download the Godot game engine. Of course, you can create games from the ground up using Java (and we would accept neat java games as well) aswell, but we will _not_ accept games made using Unity, Unreal Engine or otherwise. 

* For property file translations, suggestions for code documentation, typos and the sort any normal text editor will do fine. Property files can be found in the resources folder, under i.e. buttons, uitext, etc. If you want to add a new translation, follow the file name format of the folder. For example, to translate new buttons add the file `ButtonText_<Language initials>_<dialect>.properties`. 
For example, if you would like to start a swedish translation of the buttons in the interface, you would create a file in the buttons folder called `ButtonText_SE_svealand.properties`, and then add the language initials to the config.properties in the settings folder.

### Contribution process
To contribute to the project, you would have to follow our internal development process:
1. Fork the main repository
2. Clone your own fork
3. Work on whatever you want that you want to contribute with (anything and everythign is appreciated greatly!) and push this to your personal branch. Remember to add unnecessary files to .gitignore. Push only java-, property-, text- or game files.
4. Send a pull request to the main repository's 'dev' branch (`brisdalen/dev`) with either self-explanatory commit messages or comments otherwise.
5. We will review your pull requests, and try to get in contact with you if there are changes we have questions about (firstly as review-comments on the pull request itself). 
6. If the review is successful, we will accept the pull request and add you to the [list of contributors!](https://github.com/brisdalen/213OSB/wiki/List-of-contributors)

## List of contributors
Click [here](https://github.com/brisdalen/213OSB/wiki/List-of-contributors) to see the list of contributors

## Future Plans
### Game Ideas
Our future plan is to create other types of games that could be interesting. As we mention we have created some draft of our ideas and we may try to create it.

![Future game ideas 1](https://i.gyazo.com/471d66d6144282c93bb107cceed83ff9.png)

### Future improvements
* Text to Image:
* Right now, the text to image feature just converts the picture into a chosen size. It could be improved and make the size more flexible, and that user can change the size themselves. 
* The same with the text. It could be better if it could be scale smarter. These pictures are based on the text file created by users. It converts the line into String[] (String array), and these String[] has a maximum length that cannot surpass a specific number. If it passes that number, it will be created into a new String[] and present on a newline. It also detects \n (newline) that created a newline into the picture.

## License
This project is licensed under the MIT license. We have chosen this license due to how non-restrictive, clear and readable it is. 

Copyright 2020 Open Source Bois

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

## Third Party Licenses
Here is a list of all the third-party tools we have used, and their licenses. Git and GitKraken has been used as tools for Version Control, whilst Godot and OpenJDK has been crucial for the first game and the interface.

<details>
  <summary> Git License </summary>\

GIT TRADEMARK POLICY
1 Purpose
The Git Project is a member project of Software Freedom Conservancy ("Conservancy"). Conservancy holds rights in the Marks on behalf of the Git Project in accordance with its non- profit charitable mission.

Conservancy has adopted this Policy to protect the Marks (as defined below) and to make sure that the identity of Git software and its free and open source nature is clear to everyone. By using this Policy, the Git Project can spread the use of the Git software while making sure that the Marks are protected in a way that's consistent with U.S. trademark law (U.S. Registration 4680534). This Policy is written to allow all clear and appropriate use of the Marks while disapproving use of the Marks in ways that could confuse users as to where the software came from, or that implies an otherwise non- existent association with the Git Project. By adhering to this Policy, you help to promote to the public the freedom to use and develop the Git software.

Throughout this Policy, the word "Marks" refers to the following:

the literal mark "Git"

The logos and graphic marks displayed and available for download at https://git-scm.com/downloads/logos

The slogan "the stupid content tracker"

This Policy is only concerned with the Marks associated with the Git Project, and does not address any copyrights associated with the Git software.

2 Guidelines for using the Marks
2.1 Trademark symbol on first mention
The first prominent mention of a Mark should be immediately followed by a symbol for, as applicable, a registered trademark (®) or an unregistered trademark (™). For example: "Git™".

This requirement is waived in all contexts where such marks are not required to protect the intellectual property rights associated with the Marks, such as email, online discussion, and academic papers. We encourage the use of the applicable symbols whenever possible, but recognize that many users will omit them in non-commercial and informal contexts.

You can use "Git and the Git logo are either registered trademarks or trademarks of Software Freedom Conservancy, Inc., corporate home of the Git Project, in the United States and/or other countries." when you need to mention "Git" in e.g. list of trademarks held by other people.

2.2 Use of the Marks without written permission
You may use the Marks without prior written permission (subject to the other sections):

To refer to the Git software in substantially unmodified form. "Substantially unmodified" means built from the source code provided by the Git Project, possibly with minor modifications including but not limited to: the enabling or disabling of certain features by default, translations into other languages, changes required for compatibility with a particular operating system distribution, or the inclusion of bug-fix patches.

To identify the Git software as a distinct component of a software offering.

To factually refer to the Git Project itself, its products, or its protocols.

In addition, you may use the Marks to refer to products, services, or communities outside of the Git software and Git Project without written permission in the following contexts:

When referring to Git software that is not substantially unmodified, to say that such software is a "derivative of" or "based on" Git.
When referring to a third-party software product and/or service that is interoperable with the Git software, in the format "[Product Name] for Git" -- provided that such use otherwise complies with the rest of this Policy.
We do not charge a fee for a license to use the Marks in these contexts. However, we do of course welcome donations. If you're interested in donating to the Git Project, care of Conservancy, visit https://git-scm.com/sfc. Conservancy is a United States 501(c)(3) public charity.

2.3 Prohibited usages of the Marks
You may not use the Marks in the following ways:

In any way likely to cause confusion as to the identity of the Git Project, the provenance of its software, or the software's license.

In any way that indicates a greater degree of association between you and the Git Project than actually exists.

In any way that implies a designated successor to Git (e.g., "Git++" is not permitted).

In any way that indicates that Git favors one distribution, platform, product, etc. over another except where explicitly indicated in writing by Conservancy.

In any other way that dilutes or otherwise infringes upon the trademark rights of Conservancy and the Git Project in the Marks.

To refer to the Git software, modified by a third party to the point of inoperability with Git software in substantially unmodified form.

In addition, you may not use any of the Marks as a syllable in a new word or as part of a portmanteau (e.g., "Gitalicious", "Gitpedia") used as a mark for a third-party product or service without Conservancy's written permission. For the avoidance of doubt, this provision applies even to third-party marks that use the Marks as a syllable or as part of a portmanteau to refer to a product or service's use of Git code.

2.4 Limitations to this Policy
This Policy does not confer any rights to use the trademarks "Software Freedom Conservancy," "Conservancy," or to use any other trademarks other than the Marks listed in Section 1. This Policy does not authorize you to act as an agent for Conservancy, enter into any agreement on behalf of or otherwise create any liability for the Git Project or Conservancy.

2.5 Use of the Marks in merchandising
You may not create and/or sell merchandise bearing any of the Marks without Conservancy's express written permission. If you are interested in using creating and/or selling merchandise bearing any of the the Marks, please send proofs of your designs to us at TRADEMARK@SFCONSERVANCY.ORG.

3 Rights reserved by Conservancy
Conservancy reserves the sole right to:

Determine compliance with this Policy.

Modify this Policy in ways consistent with its mission of protecting the public.

Grant exceptions to this Policy, of any kind and for any reason whatsoever, other clauses notwithstanding.

4 Questions
This Policy is designed to keep the Marks safe in order to protect this software's reputation, earned by the contributions of the Git Project to the free and open source software community and to the public at large. If you see any use of the Marks anywhere that you think violates this Policy or otherwise goes against the spirit of the Git Project and Conservancy's mission, please bring it to Conservancy's attention by contacting us at TRADEMARK@SFCONSERVANCY.ORG.

If you have questions about using the Marks, or if you think you should be able to use the Marks for any purpose not allowed by this Policy and would like permission for that use, please contact Conservancy by emailing TRADEMARK@SFCONSERVANCY.ORG or by writing to Git Project c/o Software Freedom Conservancy, 137 Montague St. Ste 380, Brooklyn, NY 11201-3548.
</details>









<details>
  <summary> GitKraken End User Agreement </summary>\

The following End User License Agreement (the “Agreement”) governs Your use of the Software (as defined below) provided to You by Axosoft, LLC, an Arizona limited liability company (“Axosoft”).

BY ACCEPTING THIS AGREEMENT, EITHER BY CLICKING A BOX INDICATING YOUR ACCEPTANCE OR BY EXECUTING A WRITTEN AGREEMENT WITH AXOSOFT THAT REFERENCES THIS AGREEMENT, YOU AGREE TO THE TERMS OF THIS AGREEMENT. IF YOU ARE ENTERING INTO THIS AGREEMENT ON BEHALF OF A COMPANY OR OTHER LEGAL ENTITY, YOU REPRESENT THAT YOU HAVE THE AUTHORITY TO BIND SUCH ENTITY AND ITS AFFILIATES TO THESE TERMS AND CONDITIONS, IN WHICH CASE THE TERMS “YOU” OR “YOUR” SHALL REFER TO SUCH ENTITY AND ITS AFFILIATES. IF YOU DO NOT HAVE SUCH AUTHORITY, OR IF YOU DO NOT AGREE WITH THESE TERMS AND CONDITIONS, YOU MUST NOT ACCEPT THIS AGREEMENT AND MAY NOT USE THE SERVICES.

This Agreement was last updated on June 14th, 2016. It is effective between You and Axosoft as of the date of You accepting this Agreement.

1. DEFINITIONS

“Authorized Use Limits” means the specific level of use at which You are authorized to execute or run the Software. This level may be measured by any combination of the following: individual named users, maximum concurrent users, license term (i.e. perpetual or limited duration), authorized use restrictions (open source projects or commercial use) or any other level of use as specified by Axosoft at the time of Your entering into this Agreement.

“Documentation” means any online help files or written instruction manuals and other standard end user written materials regarding the Software that may be provided by Axosoft from time to time that is posted online or included with the software.

“License Term” means the time period that the Software is licensed to You, as specified by Axosoft at the time of Your entering into this Agreement.

“Software” means the particular version of the Axosoft proprietary software program supplied by Axosoft to You under the name GitKraken, including any Software updates and Documentation. You acknowledge that Axosoft may provide multiple versions of the Software, some of which may be free of charge and others which may require payment. Under no circumstances shall you be entitled to anything but the specific version of the Software that Axosoft provides to you at the time you enter into this Agreement.

“Technical Support” or “Support” means the end user support for the Software that may be provided by Axosoft during the License Term, as defined in Section 3 below.

2. LICENSE GRANT; RESTRICTIONS; YOUR RESPONSIBILITIES

2.1 License Grant. Subject to the other terms, conditions and limitations hereof, Axosoft grants to You during the License Term the non-transferable, non-exclusive license (a) to install and use the Software, subject to Your Authorized Use Limits, solely for Your own personal and internal business purposes (which business purposes may include use for open source projects and commercial projects) and in accordance with the Documentation; (b) to make a reasonable number of copies of the Software solely for archival and backup purposes; and (c) store or install a copy of the Software on a storage device such as a network server, used only to install or run the Software on Your other computers on an internal network up to your Authorized Use Limits. You may permit agents or contractors (including, without limitation, outsourcers) to use the Software on Your behalf solely for Your own personal and internal business purposes, provided that You are responsible for the agents', contractors' and outsourcers' compliance with this Agreement in such use. You must reproduce on all copies of the Software all copyright notices and other proprietary legends on the original copy of the Software.

2.2 Restrictions. The licenses granted to You in this Agreement are subject to the following additional restrictions: (i) Your use of the Software shall be limited to Your Authorized Use Limits and shall not be used either outside those Authorized Use Limits; (ii) You shall not license, sell, rent, lease, transfer, assign, distribute, host, outsource, disclose or otherwise commercially exploit or make the Software available to any third party except as expressly provided for in Section 2.1 above; (iii) You shall not modify, make derivative works of, disassemble, reverse compile, or reverse engineer any part of the Software, or access or use the Software in order to build a similar or competitive product or service; (iv) except as expressly stated in Section 2.1 above, no part of the Software may be copied, reproduced, distributed, republished, downloaded, displayed, posted or transmitted in any form or by any means, including but not limited to electronic, mechanical, photocopying, recording, or other means; and (v) You acknowledge and agree that Axosoft shall own all right, title and interest in and to all intellectual property rights (including all derivatives or improvements thereof) in the Software and any suggestions, enhancement requests, feedback, recommendations or other information provided by You or any of Your agents, contractors and outsourcers relating to the Software.

2.3 Your Responsibilities. You shall register and use the Software only in accordance with the Documentation and applicable laws and government regulations. You shall not knowingly permit anyone to use the Software for purposes of deriving its source code or for purposes other than as authorized in this Agreement. You agree to use all reasonable efforts to ensure that persons employed by You or under Your direction and control abide by the terms and conditions of this Agreement. In the event You become aware that the Software is being used by such persons in a manner not authorized by this Agreement, You shall immediately notify Axosoft in writing of such facts and You shall immediately use all reasonable efforts to have such unauthorized use of the Software immediately cease, and to recover any copies of the Software that were made in violation of this Agreement.

2.4 Usage and Other Data. The Software, by default, automatically collects and sends to Axosoft and/or its third party agents (a) general usage information, such as actions and durations of those actions and (b) bug reports when the Software experiences a crash. This information is used by Axosoft to improve the Software and related products and services. If you do not want Axosoft to collect such general usage information and/or bug reports, You may opt out from the application settings screens.

3. TECHNICAL SUPPORT

During the License Term, You will be entitled to any general released updates for the Software (which may be automatically installed and/or made available for download), as well as access any online user guides, knowledge bases and self-help tools, or other technical support resources (collectively, “Technical Support”) offered by Axosoft from time to time. Technical Support may be modified by Axosoft in its sole discretion, effective immediately upon posting on the Axosoft website.

4. INTELLECTUAL PROPERTY RIGHTS

4.1 Intellectual Property Rights. Axosoft and its licensors own all right, title and interest to the Software and any modifications, ideas, or recommendations provided by You, together with all associated intellectual property rights. You assign to and agree that Axosoft shall own and have the right to exploit and including in the Software any suggestions, enhancements requests, feedback, recommendations or other information provided by You related to the Software or any other Axosoft product or service. This Agreement does not convey or transfer any ownership in the Software or any other Axosoft product or service, or their associated intellectual property rights. Your license rights to the Software pursuant to this Agreement are strictly limited to the right to use in accordance with the terms of this Agreement. This Agreement provides You with no use rights to any other Axosoft product or service. Should You desire to purchase other products or services, please contact Axosoft for assistance in doing so.

4.2 Third Party Software. Use of some third-party materials (including open source materials) included in the Software or upon which the Software is dependent is subject to terms and conditions found in a separate agreement or “Read Me” file located in or near such materials (where the material is included with the Software), as well as posted on the Software’s about page. You acknowledge (a) Your receipt of such separate written agreements; (b) that You are bound by such terms and conditions; (c) and that Your breach of such terms and conditions shall also be deemed a breach of this Agreement.

5. LIMITED WARRANTIES; LIABILITY LIMITATIONS

5.1 To the fullest extent permitted by law, the Software is provided on an “AS IS” basis, WITHOUT REMEDIES OR WARRANTIES OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING WITHOUT LIMITATION THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, TITLE AND NON-INFRINGEMENT. THE ENTIRE RISK AS TO THE QUALITY AND PERFORMANCE OF THE SOFTW ARE IS BORNE BY YOU. AXOSOFT DOES NOT REPRESENT OR W ARRANT THA T THE SOFTWARE WILL SATISFY YOUR REQUIREMENTS; WILL OPERATE WITHOUT INTERRUPTION; IS SECURE, FREE FROM BUGS, VIRUSES, INTERRUPTIONS, ERRORS, OR OTHER PROGRAM LIMITATIONS. YOU FURTHER ACKNOWLEDGE THAT THERE IS NO GUARANTEE THAT THE SOFTWARE WILL PERFORM AS YOU ANTICIPATE. YOU ASSUME ALL RESPONSIBILITY FOR DETERMINING WHETHER THE SOFTW ARE OR THE INFORMA TION GENERA TED THEREBY IS ACCURATE OR SUFFICIENT FOR YOUR PURPOSES. YOU ASSUME FALL RESPONSIBILITY FOR YOUR USE OF THE SOFTWARE, INCLUDING REGULARLY BACKING-UP YOUR DATA.

YOU EXPRESSLY AGREE THAT YOUR USE OF THE SOFTWARE IS AT YOUR SOLE RISK. IF YOU DOWNLOAD AND/OR USE THE SOFTWARE, YOU DO SO AT YOUR OWN DISCRETION AND RISK. YOU WILL BE SOLELY RESPONSIBLE FOR ANY DAMAGE TO YOUR COMPUTER SYSTEM OR MOBILE DEVICE OR LOSS OF DATA THAT RESULTS FROM THE USE OF THE SOFTWARE OR THE DOWNLOAD OF ANY SOFTWARE. WE RESERVE THE RIGHT TO RESTRICT OR TERMINATE YOUR ACCESS TO THE SOFTWARE OR ANY FEATURE OR PART THEREOF AT ANY TIME. AXOSOFT ASSUMES NO RESPONSIBILITY FOR THE DELETION, MIS-DELIVERY OR FAILURE TO STORE ANY DATA OR PERSONALIZATION SETTINGS.

5.2 Limitation of Liability. TO THE MAXIMUM EXTENT PERMITTED BY APPLICABLE LAW, IN NO EVENT SHALL AXOSOFT BE LIABLE TO YOU OR ANY THIRD PARTY FOR ANY INCIDENTAL, CONSEQUENTIAL, PUNITIVE, SPECIAL, EXEMPLARY OR INDIRECT DAMAGES OF ANY TYPE OR KIND (INCLUDING LOST PROFITS, LOST SAVINGS, CURRENCY CONVERSION LOSSES, OR LOSS OF OTHER ECONOMIC ADVANTAGE) ARISING FROM BREACH OF WARRANTY OR BREACH OF CONTRACT, OR NEGLIGENCE, OR ANY OTHER LEGAL CAUSE OF ACTION ARISING FROM OR IN CONNECTION WITH THIS AGREEMENT OR AXOSOFT'S PERFORMANCE HEREUNDER, INCLUDING WITHOUT LIMITATION THE SOFTWARE OR ANY INTERRUPTION OF USE OF THE SOFTWARE, EVEN IF AXOSOFT HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES AND NOTWITHSTANDING THE FAILURE OF ESSENTIAL PURPOSE OF ANY LIMITED REMEDY.

IF YOU HAVE RECEIVED YOUR LICENSE FREE OF CHARGE, IT IS THE PARTIES EXPRESS INTENT THAT AXOSOFT NOT BE LIABLE TO YOU FOR ANY MONETARY DAMAGES AND THAT YOUR SOLE REMEDY FOR ANY BREACH OF THIS AGREEMENT SHALL BE TERMINATION OF THE AGREEMENT. HOWEVER, IF IT IS DETERMINED BY A COURT OF COMPETENT JURISDICTION THAT SUCH LIMITATIONS OF LIABILITY IS NOT LEGALLY ENFORCEABLE, IN NO EVENT SHALL AXOSOFT’S AGGREGATE LIABILITY ARISING OUT OF OR RELATED TO THIS AGREEMENT, WHETHER ARISING OUT OF OR RELATED TO BREACH OF CONTRACT, TORT (INCLUDING NEGLIGENCE), OR OTHERWISE, EXCEED $50.00 USD.

IF YOU HAVE PURCHASED A LICENSE, IN NO EVENT SHALL AXOSOFT’S AGGREGATE LIABILITY ARISING OUT OF OR RELATED TO THIS AGREEMENT, WHETHER ARISING OUT OF OR RELATED TO BREACH OF CONTRACT, TORT (INCLUDING NEGLIGENCE), OR OTHERWISE, EXCEED THE TOTAL AMOUNT PAID BY YOU TO AXOSOFT IN THE TWELVE (12) MONTHS IMMEDIATELY PROCEEDING THE EVENTS FIRST GIVING RISE TO A CLAIM.

6. TERM AND TERMINATION

6.1 License Term. The License Term is as specified by Axosoft at the time of Your entering into this Agreement and specific to the version of GitKraken licensed to You. If Your license is limited in time, the License Term shall commence upon the date set forth on the Order Form and shall continue for the period of time set forth by Axosoft at the time of Your order.

6.2 Termination; Effect of Expiration or Termination. In the event of any breach of this Agreement by either party, the non-breaching party shall have the right to terminate the Agreement for cause if such breach has not been cured within 30 days of written notice from the non-breaching party specifying the breach in detail. Axosoft shall also have a right to terminate this Agreement for cause if You are in breach of any other agreement with Axosoft. Upon any termination of the Agreement, (a) You shall immediately discontinue use of the Software and destroy all copies of the Software in Your possession or control; and (b) if Axosoft requests, You agree to promptly provide Axosoft with written certification of the destruction. The following provisions shall survive any termination of this Agreement: Sections 4, 5, 6, and 7.

7. GENERAL PROVISIONS

7.1 Notice. Notices regarding this Agreement to Axosoft shall be in writing and sent by first class mail or overnight courier (if from within the USA), or international courier, addressed to Axosoft at the address provided at the time of Your order. Axosoft may give notice to You by electronic mail to Your e-mail address on record with Axosoft, or by written communication sent by first class mail or overnight courier (if to an address within the USA), or international courier, to Your address on record in Axosoft's account information. All notices shall be deemed to have been given three days after mailing or posting (if sent by first class mail), upon delivery in the case of courier, or 12 hours after sending by confirmed facsimile or e-mail.

7.2 Export. You agree that U.S. export control laws and other applicable export and import laws govern Your use of the Software. You represent that You are not a citizen of an embargoed country or prohibited end user under applicable U.S. export and anti-terrorism laws, regulations and lists. You will not use, export or allow a third party to use or export the Software in any manner that would violate applicable law, including but not limited to export control laws and regulations.

7.3 Force Majeure. Neither party will be responsible for failure of performance due to causes beyond its control. Such causes include (without limitation) accidents, acts of God, labor disputes, actions of any government agency, shortage of materials, acts of terrorism, or the stability or availability of the Internet or a portion thereof.

7.4 Governing Law; Jurisdiction. This Agreement shall be governed by the laws of the State of Arizona and controlling U.S. federal law. The Uniform Computer Information Transactions Act, the United Nations Convention on the International Sale of Goods, and choice of law rules of any jurisdiction will not apply to this Agreement. Any legal action or proceeding relating to this Agreement shall be instituted in a state or federal court in Maricopa County, Arizona, and each party hereby submits to the personal jurisdiction of such courts and waives any defense relating to venue or forum non convenience.

7.5 Integration; Modification. This Agreement together with any purchase order, represents the parties' entire understanding relating to the subject matter herein, and supersedes any prior or contemporaneous, conflicting or additional, communications. Except as otherwise set forth herein, the terms and conditions of this Agreement may only be amended by written agreement of the parties. Nothing contained in any purchase order submitted by You shall in any way serve to modify or add to the terms of this Agreement.

7.6 Severability. If any provision of this Agreement is determined to be illegal or unenforceable, that provision will be limited to the minimum extent necessary so that this Agreement shall otherwise remain in full force and effect.

7.7 Relationship of Parties. No joint venture, partnership, employment, or agency relationship exists between Axosoft and You as a result of this Agreement or use of the Software.

7.8 Waiver. The failure of either party to enforce any right or provision in this Agreement shall not constitute a waiver of such right or provision unless acknowledged and agreed to by such party in writing.

7.9 Refunds. For paid editions of GitKraken, Axosoft will provide a full refund of the entire purchase amount, should you be unsatisfied with your purchase for any reason, for up to 30 days after your initial purchase date. Subsequent recurring charges or cancelations after 30 days are not eligible for a refund.
</details>







<details>
  <summary>Godot License</summary>\
  
Godot Engine is free and open source software released under the permissive MIT license
Copyright (c) 2007-2020 Juan Linietsky, Ariel Manzur.
Copyright (c) 2014-2020 Godot Engine contributors.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

-- Godot Engine <https://godotengine.org>
</details>













<details>
  <summary>OpenJDK License</summary>\

The GNU General Public License (GPL)

Version 2, June 1991

Copyright (C) 1989, 1991 Free Software Foundation, Inc.
59 Temple Place, Suite 330, Boston, MA 02111-1307 USA

Everyone is permitted to copy and distribute verbatim copies of this license
document, but changing it is not allowed.

Preamble

The licenses for most software are designed to take away your freedom to share
and change it.  By contrast, the GNU General Public License is intended to
guarantee your freedom to share and change free software--to make sure the
software is free for all its users.  This General Public License applies to
most of the Free Software Foundation's software and to any other program whose
authors commit to using it.  (Some other Free Software Foundation software is
covered by the GNU Library General Public License instead.) You can apply it to
your programs, too.

When we speak of free software, we are referring to freedom, not price.  Our
General Public Licenses are designed to make sure that you have the freedom to
distribute copies of free software (and charge for this service if you wish),
that you receive source code or can get it if you want it, that you can change
the software or use pieces of it in new free programs; and that you know you
can do these things.

To protect your rights, we need to make restrictions that forbid anyone to deny
you these rights or to ask you to surrender the rights.  These restrictions
translate to certain responsibilities for you if you distribute copies of the
software, or if you modify it.

For example, if you distribute copies of such a program, whether gratis or for
a fee, you must give the recipients all the rights that you have.  You must
make sure that they, too, receive or can get the source code.  And you must
show them these terms so they know their rights.

We protect your rights with two steps: (1) copyright the software, and (2)
offer you this license which gives you legal permission to copy, distribute
and/or modify the software.

Also, for each author's protection and ours, we want to make certain that
everyone understands that there is no warranty for this free software.  If the
software is modified by someone else and passed on, we want its recipients to
know that what they have is not the original, so that any problems introduced
by others will not reflect on the original authors' reputations.

Finally, any free program is threatened constantly by software patents.  We
wish to avoid the danger that redistributors of a free program will
individually obtain patent licenses, in effect making the program proprietary.
To prevent this, we have made it clear that any patent must be licensed for
everyone's free use or not licensed at all.

The precise terms and conditions for copying, distribution and modification
follow.

TERMS AND CONDITIONS FOR COPYING, DISTRIBUTION AND MODIFICATION

0. This License applies to any program or other work which contains a notice
placed by the copyright holder saying it may be distributed under the terms of
this General Public License.  The "Program", below, refers to any such program
or work, and a "work based on the Program" means either the Program or any
derivative work under copyright law: that is to say, a work containing the
Program or a portion of it, either verbatim or with modifications and/or
translated into another language.  (Hereinafter, translation is included
without limitation in the term "modification".) Each licensee is addressed as
"you".

Activities other than copying, distribution and modification are not covered by
this License; they are outside its scope.  The act of running the Program is
not restricted, and the output from the Program is covered only if its contents
constitute a work based on the Program (independent of having been made by
running the Program).  Whether that is true depends on what the Program does.

1. You may copy and distribute verbatim copies of the Program's source code as
you receive it, in any medium, provided that you conspicuously and
appropriately publish on each copy an appropriate copyright notice and
disclaimer of warranty; keep intact all the notices that refer to this License
and to the absence of any warranty; and give any other recipients of the
Program a copy of this License along with the Program.

You may charge a fee for the physical act of transferring a copy, and you may
at your option offer warranty protection in exchange for a fee.

2. You may modify your copy or copies of the Program or any portion of it, thus
forming a work based on the Program, and copy and distribute such modifications
or work under the terms of Section 1 above, provided that you also meet all of
these conditions:

    a) You must cause the modified files to carry prominent notices stating
    that you changed the files and the date of any change.

    b) You must cause any work that you distribute or publish, that in whole or
    in part contains or is derived from the Program or any part thereof, to be
    licensed as a whole at no charge to all third parties under the terms of
    this License.

    c) If the modified program normally reads commands interactively when run,
    you must cause it, when started running for such interactive use in the
    most ordinary way, to print or display an announcement including an
    appropriate copyright notice and a notice that there is no warranty (or
    else, saying that you provide a warranty) and that users may redistribute
    the program under these conditions, and telling the user how to view a copy
    of this License.  (Exception: if the Program itself is interactive but does
    not normally print such an announcement, your work based on the Program is
    not required to print an announcement.)

These requirements apply to the modified work as a whole.  If identifiable
sections of that work are not derived from the Program, and can be reasonably
considered independent and separate works in themselves, then this License, and
its terms, do not apply to those sections when you distribute them as separate
works.  But when you distribute the same sections as part of a whole which is a
work based on the Program, the distribution of the whole must be on the terms
of this License, whose permissions for other licensees extend to the entire
whole, and thus to each and every part regardless of who wrote it.

Thus, it is not the intent of this section to claim rights or contest your
rights to work written entirely by you; rather, the intent is to exercise the
right to control the distribution of derivative or collective works based on
the Program.

In addition, mere aggregation of another work not based on the Program with the
Program (or with a work based on the Program) on a volume of a storage or
distribution medium does not bring the other work under the scope of this
License.

3. You may copy and distribute the Program (or a work based on it, under
Section 2) in object code or executable form under the terms of Sections 1 and
2 above provided that you also do one of the following:

    a) Accompany it with the complete corresponding machine-readable source
    code, which must be distributed under the terms of Sections 1 and 2 above
    on a medium customarily used for software interchange; or,

    b) Accompany it with a written offer, valid for at least three years, to
    give any third party, for a charge no more than your cost of physically
    performing source distribution, a complete machine-readable copy of the
    corresponding source code, to be distributed under the terms of Sections 1
    and 2 above on a medium customarily used for software interchange; or,

    c) Accompany it with the information you received as to the offer to
    distribute corresponding source code.  (This alternative is allowed only
    for noncommercial distribution and only if you received the program in
    object code or executable form with such an offer, in accord with
    Subsection b above.)

The source code for a work means the preferred form of the work for making
modifications to it.  For an executable work, complete source code means all
the source code for all modules it contains, plus any associated interface
definition files, plus the scripts used to control compilation and installation
of the executable.  However, as a special exception, the source code
distributed need not include anything that is normally distributed (in either
source or binary form) with the major components (compiler, kernel, and so on)
of the operating system on which the executable runs, unless that component
itself accompanies the executable.

If distribution of executable or object code is made by offering access to copy
from a designated place, then offering equivalent access to copy the source
code from the same place counts as distribution of the source code, even though
third parties are not compelled to copy the source along with the object code.

4. You may not copy, modify, sublicense, or distribute the Program except as
expressly provided under this License.  Any attempt otherwise to copy, modify,
sublicense or distribute the Program is void, and will automatically terminate
your rights under this License.  However, parties who have received copies, or
rights, from you under this License will not have their licenses terminated so
long as such parties remain in full compliance.

5. You are not required to accept this License, since you have not signed it.
However, nothing else grants you permission to modify or distribute the Program
or its derivative works.  These actions are prohibited by law if you do not
accept this License.  Therefore, by modifying or distributing the Program (or
any work based on the Program), you indicate your acceptance of this License to
do so, and all its terms and conditions for copying, distributing or modifying
the Program or works based on it.

6. Each time you redistribute the Program (or any work based on the Program),
the recipient automatically receives a license from the original licensor to
copy, distribute or modify the Program subject to these terms and conditions.
You may not impose any further restrictions on the recipients' exercise of the
rights granted herein.  You are not responsible for enforcing compliance by
third parties to this License.

7. If, as a consequence of a court judgment or allegation of patent
infringement or for any other reason (not limited to patent issues), conditions
are imposed on you (whether by court order, agreement or otherwise) that
contradict the conditions of this License, they do not excuse you from the
conditions of this License.  If you cannot distribute so as to satisfy
simultaneously your obligations under this License and any other pertinent
obligations, then as a consequence you may not distribute the Program at all.
For example, if a patent license would not permit royalty-free redistribution
of the Program by all those who receive copies directly or indirectly through
you, then the only way you could satisfy both it and this License would be to
refrain entirely from distribution of the Program.

If any portion of this section is held invalid or unenforceable under any
particular circumstance, the balance of the section is intended to apply and
the section as a whole is intended to apply in other circumstances.

It is not the purpose of this section to induce you to infringe any patents or
other property right claims or to contest validity of any such claims; this
section has the sole purpose of protecting the integrity of the free software
distribution system, which is implemented by public license practices.  Many
people have made generous contributions to the wide range of software
distributed through that system in reliance on consistent application of that
system; it is up to the author/donor to decide if he or she is willing to
distribute software through any other system and a licensee cannot impose that
choice.

This section is intended to make thoroughly clear what is believed to be a
consequence of the rest of this License.

8. If the distribution and/or use of the Program is restricted in certain
countries either by patents or by copyrighted interfaces, the original
copyright holder who places the Program under this License may add an explicit
geographical distribution limitation excluding those countries, so that
distribution is permitted only in or among countries not thus excluded.  In
such case, this License incorporates the limitation as if written in the body
of this License.

9. The Free Software Foundation may publish revised and/or new versions of the
General Public License from time to time.  Such new versions will be similar in
spirit to the present version, but may differ in detail to address new problems
or concerns.

Each version is given a distinguishing version number.  If the Program
specifies a version number of this License which applies to it and "any later
version", you have the option of following the terms and conditions either of
that version or of any later version published by the Free Software Foundation.
If the Program does not specify a version number of this License, you may
choose any version ever published by the Free Software Foundation.

10. If you wish to incorporate parts of the Program into other free programs
whose distribution conditions are different, write to the author to ask for
permission.  For software which is copyrighted by the Free Software Foundation,
write to the Free Software Foundation; we sometimes make exceptions for this.
Our decision will be guided by the two goals of preserving the free status of
all derivatives of our free software and of promoting the sharing and reuse of
software generally.

NO WARRANTY

11. BECAUSE THE PROGRAM IS LICENSED FREE OF CHARGE, THERE IS NO WARRANTY FOR
THE PROGRAM, TO THE EXTENT PERMITTED BY APPLICABLE LAW.  EXCEPT WHEN OTHERWISE
STATED IN WRITING THE COPYRIGHT HOLDERS AND/OR OTHER PARTIES PROVIDE THE
PROGRAM "AS IS" WITHOUT WARRANTY OF ANY KIND, EITHER EXPRESSED OR IMPLIED,
INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
FITNESS FOR A PARTICULAR PURPOSE.  THE ENTIRE RISK AS TO THE QUALITY AND
PERFORMANCE OF THE PROGRAM IS WITH YOU.  SHOULD THE PROGRAM PROVE DEFECTIVE,
YOU ASSUME THE COST OF ALL NECESSARY SERVICING, REPAIR OR CORRECTION.

12. IN NO EVENT UNLESS REQUIRED BY APPLICABLE LAW OR AGREED TO IN WRITING WILL
ANY COPYRIGHT HOLDER, OR ANY OTHER PARTY WHO MAY MODIFY AND/OR REDISTRIBUTE THE
PROGRAM AS PERMITTED ABOVE, BE LIABLE TO YOU FOR DAMAGES, INCLUDING ANY
GENERAL, SPECIAL, INCIDENTAL OR CONSEQUENTIAL DAMAGES ARISING OUT OF THE USE OR
INABILITY TO USE THE PROGRAM (INCLUDING BUT NOT LIMITED TO LOSS OF DATA OR DATA
BEING RENDERED INACCURATE OR LOSSES SUSTAINED BY YOU OR THIRD PARTIES OR A
FAILURE OF THE PROGRAM TO OPERATE WITH ANY OTHER PROGRAMS), EVEN IF SUCH HOLDER
OR OTHER PARTY HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES.

END OF TERMS AND CONDITIONS

How to Apply These Terms to Your New Programs

If you develop a new program, and you want it to be of the greatest possible
use to the public, the best way to achieve this is to make it free software
which everyone can redistribute and change under these terms.

To do so, attach the following notices to the program.  It is safest to attach
them to the start of each source file to most effectively convey the exclusion
of warranty; and each file should have at least the "copyright" line and a
pointer to where the full notice is found.

    One line to give the program's name and a brief idea of what it does.

    Copyright (C) <year> <name of author>

    This program is free software; you can redistribute it and/or modify it
    under the terms of the GNU General Public License as published by the Free
    Software Foundation; either version 2 of the License, or (at your option)
    any later version.

    This program is distributed in the hope that it will be useful, but WITHOUT
    ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
    FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for
    more details.

    You should have received a copy of the GNU General Public License along
    with this program; if not, write to the Free Software Foundation, Inc., 59
    Temple Place, Suite 330, Boston, MA 02111-1307 USA

Also add information on how to contact you by electronic and paper mail.

If the program is interactive, make it output a short notice like this when it
starts in an interactive mode:

    Gnomovision version 69, Copyright (C) year name of author Gnomovision comes
    with ABSOLUTELY NO WARRANTY; for details type 'show w'.  This is free
    software, and you are welcome to redistribute it under certain conditions;
    type 'show c' for details.

The hypothetical commands 'show w' and 'show c' should show the appropriate
parts of the General Public License.  Of course, the commands you use may be
called something other than 'show w' and 'show c'; they could even be
mouse-clicks or menu items--whatever suits your program.

You should also get your employer (if you work as a programmer) or your school,
if any, to sign a "copyright disclaimer" for the program, if necessary.  Here
is a sample; alter the names:

    Yoyodyne, Inc., hereby disclaims all copyright interest in the program
    'Gnomovision' (which makes passes at compilers) written by James Hacker.

    signature of Ty Coon, 1 April 1989

    Ty Coon, President of Vice

This General Public License does not permit incorporating your program into
proprietary programs.  If your program is a subroutine library, you may
consider it more useful to permit linking proprietary applications with the
library.  If this is what you want to do, use the GNU Library General Public
License instead of this License.


"CLASSPATH" EXCEPTION TO THE GPL

Certain source files distributed by Oracle America and/or its affiliates are
subject to the following clarification and special exception to the GPL, but
only where Oracle has expressly included in the particular source file's header
the words "Oracle designates this particular file as subject to the "Classpath"
exception as provided by Oracle in the LICENSE file that accompanied this code."

    Linking this library statically or dynamically with other modules is making
    a combined work based on this library.  Thus, the terms and conditions of
    the GNU General Public License cover the whole combination.

    As a special exception, the copyright holders of this library give you
    permission to link this library with independent modules to produce an
    executable, regardless of the license terms of these independent modules,
    and to copy and distribute the resulting executable under terms of your
    choice, provided that you also meet, for each linked independent module,
    the terms and conditions of the license of that module.  An independent
    module is a module which is not derived from or based on this library.  If
    you modify this library, you may extend this exception to your version of
    the library, but you are not obligated to do so.  If you do not wish to do
    so, delete this exception statement from your version.




ADDITIONAL INFORMATION ABOUT LICENSING

Certain files distributed by Oracle America, Inc. and/or its affiliates are
subject to the following clarification and special exception to the GPLv2,
based on the GNU Project exception for its Classpath libraries, known as the
GNU Classpath Exception.

Note that Oracle includes multiple, independent programs in this software
package.  Some of those programs are provided under licenses deemed
incompatible with the GPLv2 by the Free Software Foundation and others.
For example, the package includes programs licensed under the Apache
License, Version 2.0 and may include FreeType. Such programs are licensed
to you under their original licenses.

Oracle facilitates your further distribution of this package by adding the
Classpath Exception to the necessary parts of its GPLv2 code, which permits
you to use that code in combination with other independent modules not
licensed under the GPLv2. However, note that this would not permit you to
commingle code under an incompatible license with Oracle's GPLv2 licensed
code by, for example, cutting and pasting such code into a file also
containing Oracle's GPLv2 licensed code and then distributing the result.

Additionally, if you were to remove the Classpath Exception from any of the
files to which it applies and distribute the result, you would likely be
required to license some or all of the other code in that distribution under
the GPLv2 as well, and since the GPLv2 is incompatible with the license terms
of some items included in the distribution by Oracle, removing the Classpath
Exception could therefore effectively compromise your ability to further
distribute the package.

Failing to distribute notices associated with some files may also create
unexpected legal consequences.

Proceed with caution and we recommend that you obtain the advice of a lawyer
skilled in open source matters before removing the Classpath Exception or
making modifications to this package which may subsequently be redistributed
and/or involve the use of third party software.
</details>
