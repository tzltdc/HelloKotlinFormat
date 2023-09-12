# One does not simply get Kotlin format working out of box.

## Context
Every time when I underestimate the friction that one has to go through to get things work as expect,
I suffer.

One would assume that it is easy to get Kotlin Format working like Google Java Format given the fact that
its ecosystem is well built. However, the truth is that it is not the case.

Here is a detailed breakdown step for any newbie like me to set up the Kotlin script properly.


## Step 0: Install `pre-commit` script. This gives us the opportunity to execute common `pre-commit` script.
```bash
brew install pre-commit
```
More details could be referred here. https://pre-commit.com/. At this point, what we have done has nothing
to do with kotlin code format. It just simply unlocks the possibility of executing a `pre-commit` script.

## Step 1: Copy the following content into the root folder of the current repo and save it as `[.pre-commit-config.yaml](.pre-commit-config.yaml)`
```yaml
repos:
  - repo: https://github.com/davehadley/ktfmt-pre-commit-hook
    rev: 0.7.0
    hooks:
      - id: ktfmt
        args: [ --version=0.44, --google-style ]
        stages: [ commit ]
```
The above script content strikes me as the configuration a `pre-commit` script.
When such configuration is executed, it will fetch the released version of `ktfmt-pre-commit-hook` and execute its content.
The good news is that we do not have to worry about how `ktfmt-pre-commit-hook` is implemented.

## Step 2: Install the yaml `pre-commit` script into `.git/hooks` folder at the root repo folder.
```bash
pre-commit install
```
You do not have to specify any target file name to install. I reckon that `pre-commit` will use `[.pre-commit-config.yaml](.pre-commit-config.yaml)` as the default value.
If I have to guess, this is the step when the implementation of `ktfmt-pre-commit-hook` will be downloaded and cached in `.git/hooks` folder
Still, at this point, your code is still at random format as it is.

## Step 3_1: Try to modify a file with a random format and commit it business as usual.
Here is the step where the final magic works together. 
You will noticed that all edits files will be formatted deterministically.


## Step 3_2: Try to execute the following command to format all existing files.
This should only be executed for once to establish the baseline. After all of this, enjoy coding.
```bash
pre-commit run --all-files
```