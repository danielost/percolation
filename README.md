# Percolation

Given a composite systems comprised of randomly distributed insulating and metallic materials: what fraction of the materials need to be metallic so that the composite system is an electrical conductor? Given a porous landscape with water on the surface (or oil below), under what conditions will the water be able to drain through to the bottom (or the oil to gush through to the surface)? Scientists have defined an abstract process known as percolation to model such situations.

# The model

We model a percolation system using an n-by-n grid of sites. Each site is either open or blocked. A full site is an open site that can be connected to an open site in the top row via a chain of neighboring (left, right, up, down) open sites. We say the system percolates if there is a full site in the bottom row. In other words, a system percolates if we fill all open sites connected to the top row and that process fills some open site on the bottom row. (For the insulating/metallic materials example, the open sites correspond to metallic materials, so that a system that percolates has a metallic path from top to bottom, with full sites conducting. For the porous substance example, the open sites correspond to empty space through which water might flow, so that a system that percolates lets water fill open sites, flowing from top to bottom.)

# Monte Carlo simulation. To estimate the percolation threshold, consider the following computational experiment:

- Initialize all sites to be blocked.
- Repeat the following until the system percolates:
    a) Choose a site uniformly at random among all blocked sites.
    b) Open the site.
- The fraction of sites that are opened when the system percolates provides an estimate of the percolation threshold.

For example, if sites are opened in a 20-by-20 lattice according to the snapshots below, then our estimate of the percolation threshold is 204/400 = 0.51 because the system percolates when the 204th site is opened.

| ![space-1.jpg](https://user-images.githubusercontent.com/72448226/160408010-641f8a3f-a4de-46fd-8fa4-3c9da67c0978.png) | ![space-1.jpg](https://user-images.githubusercontent.com/72448226/160408124-7917f474-30dc-4c33-b144-16495b45f123.png) | ![space-1.jpg](https://user-images.githubusercontent.com/72448226/160408164-790f956c-7344-4ab2-a71d-488845efe8e8.png) | ![space-1.jpg](https://user-images.githubusercontent.com/72448226/160408204-f81cf4bc-6127-4eb6-b168-c11fab0a6c80.png) |
|:--:|:--:|:--:|:--:|
| 50 open sites|100 open sites|150 open sites|204 open sites|
