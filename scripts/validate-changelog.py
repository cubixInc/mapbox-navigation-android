#!/usr/bin/python

import sys
import requests
import re

print("Validating that changelog entry is provided in the PR description...")

pr_number = sys.argv[1]
github_username = sys.argv[2]
github_token = sys.argv[3]
url = "https://api.github.com/repos/mapbox/mapbox-navigation-android/pulls/" + pr_number
headers = { "accept": "application/vnd.github.v3+json", "authorization": github_username + " " + github_token }
with requests.get(url, headers = headers) as r:
  response_json = r.json()
  pr_description = response_json["body"]
  pr_labels = response_json["labels"]

  if pr_labels is not None:
    for label in pr_labels:
      if label["name"] == "skip changelog":
        print("`skip changelog` label present, exiting.")
        exit()

  match = re.search(r'<changelog>(.+)</changelog>', pr_description)
  assert match is not None, "Add a changelog entry in a `<changelog></changelog>` closure in the PR description or add a `skip changelog` label if not applicable."

print("Changelog entry validation successful")