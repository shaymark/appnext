# appnext

stracture and packages:

di - service locator provider
db - room databse
network - retrofit
viewmodels - android view models init with viewModelFactory
ui - single activity app with two fragments: AppDetetailsFragment, AppsListFragment
   - appsAdapter - using ListAdapter with custome AppDiffUtil
services - PopularAppsWorker - using Worker to schedule update every 12 hours

using corutines and flow

known issues (i didn't had time to solve it):

- details screen is not design
- job manager update the apps every time you open the app not as required
- when updating the apps the app adding more apps and not removing old apps
